SELECT store_id, city_name
FROM store_info
	JOIN city_info ON store_info.city_id = city_info.city_id
WHERE store_id IN (
	SELECT store_id, SUM(order_id)
	FROM order_detail
	GROUP BY store_id
	HAVING SUM(order_id) > 10000
);