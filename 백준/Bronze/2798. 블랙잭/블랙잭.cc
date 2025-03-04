#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>
using namespace std;

int main()
{
    int n,m;
    vector<int>k;
    cin>>n>>m;
    int tmp;
    for(int i=0;i<n;i++){
        cin>>tmp;
        k.push_back(tmp);
    }
    int max=0;
    int res=0;
    sort(k.begin(),k.end());
    for(int i=0;i<k.size();i++)
    {
        for(int j=i+1;j<k.size();j++)
        {
            for(int l=j+1;l<k.size();l++)
            {
                res=k[i]+k[j]+k[l];
                if(res<=m)
                {
                    if(res>max)
                        max=res;
                }
            }
        }
    }
    cout<<max;
    
}