	# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys

while True:
	num = int(input())
	if num == 0 or num > 1000:
		sys.exit(0)
		
	money_list = []
	rest_money = 0
	
	for i in range(num):
		money = float(input())
		if money >= 100000:
			sys.exit(0)
		money_list.append(money)
	

	money_list.sort(reverse=True)

	avg = round(round((sum(money_list)/num),3),3)
	
	result = 0
	for i in range(len(money_list)):
		money_list[i] = round(money_list[i]-avg,2)
		if money_list[i] > 0:
			result+=money_list[i]
			
	print("${0:0.2f}".format(result))
	
	


