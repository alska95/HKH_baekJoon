#include <stdio.h>

int main(void) {

	int num;
	int numbers[1000];
	int count = 0;
	scanf("%d", &num);

	for (int i = 0; i < num; i++)
		scanf("%d", &numbers[i]);


	for (int i = 0; i < num; i++) {
		int divNum = 1;

		if (numbers[i] == 1)
		{
			count++;
			continue;
		}

		while (divNum*divNum <= numbers[i]) {
			if (divNum == 1) {
				divNum++;
				continue;
			}
			if (numbers[i] % divNum == 0)
			{
				count++;
				break;
			}
			divNum++;
		}
	}

	printf("%d\n", num - count);


	return 0;
}
