# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

num = int(input())
	
for step in range(num):
	P,N = map(int,input().split())

	write_data = []
	erdos_dict = {}
	print_list = []
	name_list = []

	for i in range(P):
		write,name = input().split(":")
		write_data = (write.split(","))

		for i in range(len(write_data)):
			write_data[i] = write_data[i].lstrip()


		if "Erdos" in write_data:
			for i in write_data:
				if i not in erdos_dict:
					erdos_dict[i] = 1

		else:
			Flag = False
			tmp = 10000000
			for i in write_data:
				if i in erdos_dict:
					Flag = True
					if erdos_dict[i] < tmp:
						tmp = erdos_dict[i]

			tmp +=1

			for i in write_data:
				if Flag:
					if i not in erdos_dict:
						erdos_dict[i] = tmp
				else:
					erdos_dict[i] = "infinity"

	for j in range(N):
		print_list.append(input())

	for k in print_list:
		first,last = k.split(",")
		name_list.append(first)
	
	print(f"Scenario {step+1}")
	for x in range(len(print_list)):
		print(f"{print_list[x]} {erdos_dict[name_list[x]]}")

	

	