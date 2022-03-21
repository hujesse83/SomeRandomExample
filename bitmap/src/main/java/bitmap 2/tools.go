package main

import "encoding/hex"

func ByteToBinaryString(data byte) (str string) {
	var a byte
	for i := 0; i < 8; i++ {
		a = data
		data <<= 1
		data >>= 1

		switch a {
		case data:
			str += "0"
		default:
			str += "1"
		}

		data <<= 1
	}
	return str
}

func intToByte(i int) []byte {
	//var h, l uint8 = uint8(i >> 8), uint8(i & 0xff)
	var h2, h1, h, l uint8 = uint8(i >> 24), uint8(i >> 16), uint8(i >> 8), uint8(i & 0xff)
	nbyte := []byte{h2, h1, h, l}
	return nbyte
}

func byteToInt(b []byte) int {
	v0 := int(b[0]) << 24
	v1 := int(b[1]) << 16
	v2 := int(b[2]) << 8
	v3 := int(b[3]) & 0xff
	return int(v0) + int(v1) + int(v2) + int(v3)
}

func byteToHex(b []byte) string {
	hexStr := hex.EncodeToString(b)
	if len(hexStr) < 8 {
		for 8-len(hexStr) > 0 {
			hexStr = "0" + hexStr
		}
	}
	return hexStr
}
