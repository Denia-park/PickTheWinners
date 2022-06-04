import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성

        System.out.println("원하시는 최소 숫자 범위를 정해주세요. [ 0 or 양의 정수 입력 ] Ex - 3");
        int minRange = sc.nextInt(); //최소 당첨번호. 해당 번호를 시작으로 당첨 번호를 뽑는다.
        if(minRange < 0){
            System.out.println("입력 값 :" + minRange + " -- 잘못 입력하셨습니다!!!");
            return;
        }

        System.out.println("원하시는 최대 숫자 범위를 정해주세요. [0 or 양의 정수 입력 ※최소 숫자 범위보다 크게 적어주세요] Ex - 15");
        int maxRange = sc.nextInt(); //최대 당첨번호. 해당 번호까지를 마지막으로 당첨 번호를 뽑는다.
        if(maxRange <= minRange){
            System.out.println("입력 값 :" + maxRange + " -- 최소 입력값 이하의 값을 적어주셨습니다.");
            return;
        }

        System.out.println("원하시는 당첨자 수를 정해주세요. [0 제외 양의 정수 입력] Ex - 5");
        int winners = sc.nextInt();
        if(winners <= 0){
            System.out.println("입력 값 :" + winners + " -- 당첨자는 0명 및 음수가 될 수 없습니다.");
            return;
        }else if(winners > (maxRange - minRange + 1)){
            System.out.println("입력 값 :" + winners + " -- 당첨자의 수가 요청하신 숫자 범위 보다 많습니다.");
            return;
        }
        int winnersCount = 0; //당첨자를 셀 변수

        boolean[] winnersArray = new boolean[maxRange - minRange + 1]; //당첨자를 저장할 배열 , 예를 들어 5 ~ 8 까지면 5 6 7 8 이므로 8-5+1가 된다.

        while (winnersCount < winners){ //당첨자를 뽑는 로직
            int selcetedRandNum = (int) (Math.random() * (maxRange - minRange + 1)); // 랜덤으로 숫자 뽑기

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
        for (int i = 0; i < winnersArray.length; i++) { //배열의 첫 인덱스부터 읽어서 표시하기 때문에 자연스럽게 오름차순으로 표시됨.
            if (winnersArray[i]) { //true 값만 표현
                System.out.print(i + minRange);
                winnersCount++;
                if(winnersCount < winners){
                    System.out.print(",");
                }
            }
        }

        System.out.print(" ]");
    }
}