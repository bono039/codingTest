-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS 
WHERE INTAKE_CONDITION NOT LIKE 'AGED'
ORDER BY ANIMAL_ID;