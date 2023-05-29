select p.id,avg(r.vote) as vote from product p
    right join ratting r on p.id = r.product_id
group by p.id having avg(r.vote) > 2 order by vote desc;