SELECT a.FLAVOR
FROM FIRST_HALF a
LEFT JOIN icecream_info b ON a.flavor = b.flavor
WHERE a.total_order > 3000 AND b.INGREDIENT_TYPE LIKE "fruit_based"
ORDER BY a.total_order DESC
