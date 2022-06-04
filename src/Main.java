import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성

        int minRange = 1; //당첨자를 뽑을 최소 숫자

        System.out.println("원하시는 숫자 범위를 정해주세요. [정수 입력] Ex - 15 / 최소값은 " + minRange);
        int maxRange = sc.nextInt();

        System.out.println("원하시는 당첨자 수를 정해주세요. [정수 입력] Ex - 5");
        int winners = sc.nextInt();
        int winnersCount = 0; //당첨자를 셀 변수

        boolean[] winnersArray = new boolean[maxRange + 1]; //당첨자를 저장할 배열

        while (winnersCount < winners){ //당첨자를 뽑는 로직
            int selcetedRandNum = (int) (Math.random() * maxRange + minRange); // 랜덤으로 숫자 뽑기

            if(!winnersArray[selcetedRandNum]){ //뽑아낸 숫자를 배열에 넣어서 당첨자를 저장
                winnersArray[selcetedRandNum] = true;
            }else{ //기존에 당첨이 되어있는 경우면 다시 당첨자를 뽑는다.
                continue;
            }

            winnersCount ++;
        }

        /* 당첨자를 표시하는 로직 */
        System.out.print("당첨자 번호 : [ ");
        winnersCount = 0;
        for (int i = 1; i < winnersArray.length; i++) { //배열의 첫 인덱스부터 읽어서 표시하기 때문에 자연스럽게 오름차순으로 표시됨.
            if (winnersArray[i]) { //true 값만 표현
                System.out.print(i);
                winnersCount++;
                if(winnersCount < winners){
                    System.out.print(",");
                }
            }
        }

        System.out.print(" ]");
    }
}