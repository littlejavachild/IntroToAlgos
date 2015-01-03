int[] input = [-1,-2,-3,4,5,6,-7,-8,-9]
print maxSubArray(input,0,input.length-1)
//----------------------------------------------------------
int maxSubArray(int[] A,int low,int high){
    if(low == high){
        return A[low]
    }else{
        int mid = (int) Math.floor((low+high)/2)
        int left = maxSubArray(A,low,mid)
        int right = maxSubArray(A,mid+1,high)
        int center = maxCrossArray(A,low,mid,high)
        return Math.max(left,Math.max(right,center))   
    }
}
//----------------------------------------------------------
int maxCrossArray(int[] A,int low,int mid,int high){
    int leftSum = 0
    int rightSum = 0
    int sum = 0
    for(int i = mid; i >= low; i--){
        sum += A[i]
        if(sum > leftSum){
            leftSum = sum
        }
    }
    sum = 0
    for(int j = mid+1; j <= high; j++){
        sum += A[j]
        if(sum > rightSum){
            rightSum = sum
        }
    }
    return leftSum+rightSum
}