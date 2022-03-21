package main

import (
	"fmt"
	"io/ioutil"
	"os"
)

var (
	dict    = [8]byte{1, 128, 64, 32, 16, 8, 4, 2}
	dict2   = [8]byte{128, 64, 32, 16, 8, 4, 2, 1}
	intDict = []int{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2,
		3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3,
		4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 1, 2, 2, 3, 2,
		3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4,
		5, 5, 6, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4,
		5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3,
		4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3,
		4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5,
		6, 6, 7, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4,
		5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5,
		6, 6, 7, 4, 5, 5, 6, 5, 6, 6, 7, 5, 6, 6, 7, 6, 7, 7, 8}
)

type BitMap struct {
	bitMap []byte
	intMap []int
	length int64
	count  int64
}

func NewBitMap(len int64) *BitMap {
	bm := &BitMap{}
	bm.length = len
	bm.bitMap = make([]byte, len/8+1)
	bm.intMap = make([]int, len/40)
	return bm
}

func (this *BitMap) Set(loc int64) {
	if loc > 0 {
		this.bitMap[(loc-1)/8] = dict[loc%8] | this.bitMap[(loc-1)/8]
		this.count++
		if this.count <= this.length/40 {
			this.intMap[this.count-1] = int(loc)
		}
	}
}

func (this *BitMap) GetCount() int64 {
	return this.count
}

func (this *BitMap) GetResult() []byte {
	if this.count <= this.length/40 {
		temp := make([]byte, this.count*4)
		i := int64(0)
		for ; i < this.count; i++ {
			temp4 := intToByte(this.intMap[i])
			j := int64(0)
			l := int64(len(temp4))
			for ; j < l; j++ {
				temp[i*l+j] = temp4[j]
			}
		}
		return temp
	}
	return this.bitMap
}

func (this *BitMap) SaveFile(filename string) error {
	fmt.Println("bitmap count:", this.count)
	return ioutil.WriteFile(filename, this.GetResult(), 0666)
}

func (this *BitMap) GetBitMapCount(filename string) int64 {
	fi, err := os.Open(filename)
	if err != nil {
		panic(err)
	}
	defer fi.Close()
	fd, _ := ioutil.ReadAll(fi)
	bitMapLength := len(fd)
	count := 0
	for i := 0; i < bitMapLength; i++ {
		count += intDict[fd[i]&0x000000ff]
	}
	fmt.Println("GetBitMapCount", filename, count)
	return int64(count)
}

func (this *BitMap) GetIntArr(filename string) []int {
	fi, err := os.Open(filename)
	if err != nil {
		panic(err)
	}
	defer fi.Close()
	fb, err := ioutil.ReadAll(fi)
	fbsize := int64(len(fb))
	var intMap []int

	if fbsize < int64(this.length/8) && fbsize%4 == 0 {
		// intmap
		i := int64(0)
		for ; i < fbsize; i += 4 {
			intMap = append(intMap, byteToInt(fb[i:i+4]))
		}
	} else {
		// bitmap
		index := 1
		for _, b := range fb {
			for i := 0; i < 8; i++ {
				if dict2[i] == (dict2[i] & b) {
					intMap = append(intMap, index)
				}
				index++
			}
		}
	}
	return intMap
}