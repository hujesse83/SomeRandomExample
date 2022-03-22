package main

import (
	"fmt"
	"testing"
)

func TestBitMap_Set(t *testing.T) {
	bm := NewBitMap(20)
	bm.Set(1)
	bm.Set(2)
	bm.Set(3)
	bmBytes := bm.GetResult()
	for i:=0;i<len(bmBytes); i++{
		fmt.Println(ByteToBinaryString(bmBytes[i]))
	}
	bm.Set(10)
	t.Log("Count:", bm.GetCount())
	err2 :=bm.SaveFile("/Users/jhu/Desktop/bitmap.bin")
	count2 :=bm.GetBitMapCount("/Users/jhu/Desktop/bitmap.bin") // 可以读到
	fmt.Println(count2)
	fmt.Println(err2)
}

func Test_dict(t *testing.T) {
	showDics()

	size := 7
	bitMap := make([]byte, size/8+1)

	loc := 7
	bitMap[(loc-1)/8] = dict[loc%8] | bitMap[(loc-1)/8]
	t.Log(loc%8, (loc-1)/8, dict[loc%8]|bitMap[(loc-1)/8])
	fmt.Println("")
	showBitmap(bitMap)

	loc = 6
	bitMap[(loc-1)/8] = dict[loc%8] | bitMap[(loc-1)/8]
	t.Log(loc%8, (loc-1)/8, dict[loc%8]|bitMap[(loc-1)/8])
	showBitmap(bitMap)
}

func showBitmap(bitmap []byte) {
	index := 1
	for _, b := range bitmap {
		for i := 0; i < 8; i++ {
			if dict2[i] == (dict2[i] & b) {
				fmt.Print(1, fmt.Sprintf("(%d,%d)", i, index))
			} else {
				fmt.Print(0)
			}
			index++
		}
	}
	fmt.Println("")
}

func showDics() {
	for k, v := range dict {
		fmt.Println(k, ByteToBinaryString(v))
	}
	fmt.Println("============")
	for k, v := range dict2 {
		fmt.Println(k, ByteToBinaryString(v))
	}
}

func Test_ByteToBinaryString(t *testing.T) {
	showDics()
}
