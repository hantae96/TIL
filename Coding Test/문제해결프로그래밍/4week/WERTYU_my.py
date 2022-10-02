# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
key_set = '1234567890-QWERTYUIOP[]ASDFGHJKL;ZXCVBNM,.'

after_key_set = "234567890-=WERTYUIOP[]\SDFGHJKL;'XCVBNM,./"

# print(len(key_set))
# print(len(after_key_set))

dic = {}

for i in range(len(key_set)):
	dic[after_key_set[i]] = key_set[i]
	
#print(dic)

while True:
	try:
		tmp=input()
		test_case = ""
		for i in tmp:
			if i == " ":
				test_case = test_case + " "
			else:
				test_case = test_case + dic[i]
		
		print(test_case)
	except:
		break