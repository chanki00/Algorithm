-- 코드를 입력하세요
# 날짜, 회원id, 상품id 조합은 하나만 존재
# 동일한 회원이 동일한 상품을 재구매한 데이터를 구해라 -> 재구매한 회원 ID와 재구매한 상품 ID를 출력

SELECT USER_ID, PRODUCT_ID 
FROM ONLINE_SALE 
GROUP BY USER_ID, PRODUCT_ID
HAVING count(*) > 1
ORDER BY USER_ID ASC, PRODUCT_ID DESC;