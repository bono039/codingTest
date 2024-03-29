SELECT A.AUTHOR_ID
     , A.AUTHOR_NAME
     , B.CATEGORY
     , SUM(S.SALES * B.PRICE) AS TOTAL_SALES
FROM AUTHOR A
JOIN BOOK B       ON A.AUTHOR_ID = B.AUTHOR_ID
JOIN BOOK_SALES S ON B.BOOK_ID   = S.BOOK_ID
WHERE DATE_FORMAT(S.SALES_DATE, '%Y-%m') = '2022-01'
GROUP BY A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY    -- 저자 별, 카테고리 별 매출액
ORDER BY A.AUTHOR_ID ASC, B.CATEGORY DESC;  -- 저자ID 오름차순, 카테고리 내림차순