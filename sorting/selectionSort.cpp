#include<iostream>
#include<vector>

using namespace std;

vector<int> arr = {1,3,5,2,4,8,6,7,9,10};

//선택정렬은 자료에서 가장 크거나 작은 데이터를 선택해서 리스트의 처음이나 마지막에 배치하면서 정렬
// 특징 : 불안정 정렬, 제자리 정렬

int main(void){

    for(int i=0;i<arr.size();i++){
        //가장 작은 값이 처음 인덱스에 있을 것이라 가정.
        int minIdx = i;

        //배열에서 최솟값의 인덱스 탐색
        for(int j=i+1;j<arr.size();j++){
            if(arr[j]<arr[minIdx]) minIdx = j;
        }
        
        //최솟값의 인덱스를 찾았다면,
        //최소값은 맨 처음 인덱스로 옮기고, 맨 처음 인덱스의 값은 최소값이 있었던 인덱스로 옮긴다.
        int temp;
        temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;
        
    }

    //정렬 끝났음으로 출력
    for(int i=0;i<arr.size();i++){
        cout<<arr[i]<<" ";
    }
    
    return 0;
}