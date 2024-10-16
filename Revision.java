package Revision_BinarySearch;

import java.util.Arrays;

public class Revision {
    static int BinarySearch(int[]arr,int target){
       int start=0;
       int end=arr.length;
       while (start<=end){
           int mid=start+(end-start)/2;
           if(arr[mid]==target){
               return mid;
           } else if (arr[mid]<target) {
               start=mid+1;
           }else {
               end=mid-1;
           }
       }
        return -1;
    }
    static int Pivot(int[] arr){
        int start=0;
        int end=arr.length-1;
        while (start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }else {
                start=mid+1;
            }
        }
        return start;
    }


    static int OrderAgnostic(int[]arr,int target,int start,int end){
        boolean isAsc=arr[start]<arr[end];
        while (start<=end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
               return mid;
            }
            if(isAsc) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }else {
                if (arr[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    static int Ceiling(int[]arr,int target){
        int start=0;
        int end=arr.length;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return arr[mid];
            }else if (arr[mid]<target) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return arr[start];
    }
    static int floor(int[]arr,int target){
        int start=0;
        int end=arr.length;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return arr[mid];
            }else if (arr[mid]<target) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return arr[end];
    }
    static int FirstAndLAstIndex(int[]arr,int target,boolean index){
        int start=0;
        int end=arr.length;
        int ans=-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]<target){
                start=mid+1;
            }else if(arr[mid]>target){
                end=mid-1;
            }else {
                ans=mid;
                if (index){
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }
        }
        return ans;
    }

    static int[] FirstAndLAstIndex2(int[]arr,int target){
        int[]ans={-1,-1};
        ans[0]=FirstAndLAstIndex(arr,target,true);
        ans[1]=FirstAndLAstIndex(arr,target,false);
        return ans;
    }

    static int BinarySearchRecursion(int[]arr,int target,int start,int end){
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            } else if (arr[mid]>target) {
              return BinarySearchRecursion(arr,target,start,mid-1);
            }else {
                return BinarySearchRecursion(arr,target,mid+1,end);
            }
        }
        return -1;
    }

    static int MinIndex(int[] arr,int target){
        int start=0;
        int end=Pivot(arr);
        int ans=OrderAgnostic(arr,target,start,end);
        if(ans!=-1){
            return ans;
        }else {
            return OrderAgnostic(arr,target,start,arr.length-1);
        }
    }
    public static void main(String[] args) {
        int[]Binary={1,2,4,5,6,8};
//        System.out.println(BinarySearch(Binary,6));
        int[]Pivot={1,2,8,10,8,4,3,2,1};
//        System.out.println(Pivot(Pivot));
        int[] OA={7,6,5,4,3,2,1};
//        System.out.println(OrderAgnostic(OA,1));
        int[] Ceiling={12,34,56,76};
//        System.out.println(Ceiling(Ceiling,13));
        int[] Floor={12,14,25,36,48,50};
//        System.out.println(floor(Floor,24));
        int[]FandLIndex={5,6,7,7,8,8,9};
//        System.out.println(Arrays.toString(FirstAndLAstIndex2(FandLIndex,8)));
        int[]BSRecursion={2,4,5,6,7,8,9};
//        System.out.println(BinarySearchRecursion(BSRecursion,4,0,BSRecursion.length));
        int[]minIndex={1,3,5,6,4,2,1};
//        System.out.println(MinIndex(minIndex,3));
    }


}
