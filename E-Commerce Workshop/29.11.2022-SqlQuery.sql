--1. İçinde bulunduğumuz aydaki siparişler
select * from orders where DATE_PART('month', order_date) = (select extract (month from current_date))

--2. Ayın ilk 15 günü ve son 15 günü sipariş farkı
Select (Select Count(*) from orders where date_part('day',order_date::timestamp)>=15)-
(Select Count(*) from orders where date_part('day',order_date::timestamp)<=15);

--3. Birthday i bu gün olan müşteriyi getir
Select * from users 
where date_part('day', birth_date::timestamp)=date_part('day', current_date::timestamp) 
and date_part('month', birth_date::timestamp)=date_part('month', current_date::timestamp) ;

--4. Kullanıcıların doğum yılları ortalaması
select AVG(DATE_PART('year', birth_date)) as "doğum yıllarının ortalaması" from users

--5. Yaşı 23 den büyük müşterileri listele
Select * from users where (date_part('year',current_date) - 
(date_part('year',birth_date))) >23

--6. Son 10 gün içerisindeki siparişler
select * from orders where 
(date_part('year',current_date) = (date_part('year',order_date)))
and (date_part('month',current_date) = (date_part('month',order_date)))
and (date_part('day',current_date) - (date_part('day',order_date))) <= 10

--7. Bugün kargoya çıkıcak siparişler
select * from orders where ship_date = (Select CURRENT_DATE)

Select * from orders where ship_date::timestamp = current_date::timestamp


--8. Son 3 günde kargoya çıkmış ürünler
select * from orders where 
(date_part('year',current_date) = (date_part('year',ship_date)))
and (date_part('month',current_date) = (date_part('month',ship_date)))
and (date_part('day',current_date) - (date_part('day',ship_date))) <= 3

--9. Kullanıcıların yaşları toplamı
Select SUM(date_part('year', current_date::timestamp)-date_part('year', birth_date::timestamp)) from users

--10. 1995 ve 2000 yılı arasında doğan kullanıcılar
Select * from users where DATE_PART('year', birth_date) between 1995 and 2000
