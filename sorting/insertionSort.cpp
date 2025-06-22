#include<iostream>
#include<vector>

using namespace std;

//삽입정렬은 이미 정렬된 자료에 새로운 레코드를 삽입하여 다시 정렬
// 특징 : 안정 정렬, 제자리 정렬
/*
1. 배열에서 하나의 수 (key)를 선택
2. key보다 큰 값을 모두 뒤로 이동
*/

vector<int> arr = {1,3,5,2,4,8,6,7,9,10};
int main(void){


    //0번 idx는 이미 정렬된 상태라고 파악
    for(int i=1;i<arr.size();i++){
        int key = arr[i]; //삽입할 값
        
        //삽입할 수보다 앞에 있는 수들 (이미 정렬되 수들)을 순회하며, 뒤로 이동
        //arr[j]가 idx -1이 될 수 있음으로 i-1로 배치해서 while조건에서 out of index 문제를 조기 해결.
        //만약 j=i; arr[j] = arr[j-1]이 되는 형태가 된다면 j-1은 -1이 되어 문제가 발생할 수 있음.
        int j = i-1;
        while(j>=0 && arr[j]>=key){
            arr[j+1] = arr[j];
            j--;
        }
        //삽입할 위치에 key값 삽입 위치는 j--한 위치의 바로 뒤
        arr[j+1] = key;
    }
    //출력
    for(int i=0;i<arr.size();i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}