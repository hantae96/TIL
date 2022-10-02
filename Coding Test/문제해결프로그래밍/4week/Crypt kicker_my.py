# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
num = int(input())
blank = input()
text = "the quick brown fox jumps over the lazy dog"

key_dict = {}

tmp = text.split()
text_num = []
for i in tmp:
	text_num.append(len(i))

for i in range(num):
	input_string = []
	while True:
		try:
			tmp = input()
			if tmp == "":
				break
			input_string.append(tmp)
		except:
			break
	
	known_text = ""
	key_dict = {}


	# 길이가 같은 암호문은 같다고 생각
	Flag = True
	for i in input_string:
		tmp_num = []
		tmp = i.split()
		
		for j in tmp:
			tmp_num.append(len(j))
			
		if tmp_num == text_num:
			known_text = i
			Flag = False

		
	if Flag and len(input_string)>0:
		print("No solution.")
		break
			
	if len(known_text)!= 0:
		for i in range(len(text)):
				key_dict[known_text[i]] = text[i]
	
	for string in input_string:
		output_string = ""
		for char in string:
			output_string = output_string + key_dict[char]
	
		print(output_string)
	print()

	
