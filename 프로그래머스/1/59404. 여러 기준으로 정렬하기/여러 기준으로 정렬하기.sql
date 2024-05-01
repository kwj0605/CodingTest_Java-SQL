-- 코드를 입력하세요
 
SELECT ANIMAL_ID,
       NAME,
       DATETIME
FROM ANIMAL_INS 
group by 2, 3
order by 2, 3 desc
