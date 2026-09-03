class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        mini=prices[0]
        profit=0

        for x in prices:
            mini=min(x,mini)
            profit=max(profit,x-mini)
        return profit