/**
 * 
 */

/**
 * @author 刘冬燕
 *
 */
public class QueryString {
	int dbid;//database ID
	public QueryString(int dbid){
		this.dbid = dbid;
	}
	public String qid2String(int qid) {
		String sql = null;
		switch (qid) {
		case 1:
			sql = "select l_returnflag,l_linestatus,sum(l_quantity) as sum_qty,sum(l_extendedprice) as sum_base_price,sum(l_extendedprice * (1 - l_discount)) as sum_disc_price,sum(l_extendedprice * (1 - l_discount) * (1 + l_tax)) as sum_charge,avg(l_quantity) as avg_qty,avg(l_extendedprice) as avg_price,avg(l_discount) as avg_disc,count(*) as count_order from lineitem where l_shipdate <= date ('1998-12-01') - interval '90' day group by l_returnflag,l_linestatus order by l_returnflag,l_linestatus;";
			break;
		case 2:
			sql = "select s_acctbal,s_name,n_name,p_partkey,p_mfgr,s_address,s_phone,s_comment from part,supplier,partsupp,nation,region where p_partkey = ps_partkey and s_suppkey = ps_suppkey and p_size = 15 and p_type like '%BRASS' and s_nationkey = n_nationkey and n_regionkey = r_regionkey and r_name = 'EUROPE' and ps_supplycost = (select min(ps_supplycost) from partsupp,supplier,nation,region where p_partkey = ps_partkey and s_suppkey = ps_suppkey and s_nationkey = n_nationkey and n_regionkey = r_regionkey and r_name ='EUROPE') order by s_acctbal desc,n_name,s_name,p_partkey;";
			break;
		case 3:
			sql = "select l_orderkey,sum(l_extendedprice * (1 - l_discount)) as revenue,o_orderdate,o_shippriority from customer,orders,lineitem where c_mktsegment = 'BUILDING' and c_custkey = o_custkey and l_orderkey = o_orderkey and o_orderdate < date ('1995-03-15') and l_shipdate > date ('1995-03-15') group by l_orderkey,o_orderdate,o_shippriority order by revenue desc,o_orderdate;";
			break;
		case 4:
			sql = "select o_orderpriority,count(*) as order_count from orders where o_orderdate >= date ('1993-7-1') and o_orderdate < date ('1993-7-1') + interval '3' month and exists ( select * from lineitem where l_orderkey = o_orderkey and l_commitdate < l_receiptdate) group by o_orderpriority order by o_orderpriority;";
			break;
		case 5:
			sql = "select n_name,sum(l_extendedprice * (1 - l_discount)) as revenue from customer,orders,lineitem,supplier,nation,region where c_custkey = o_custkey and l_orderkey = o_orderkey and l_suppkey = s_suppkey and c_nationkey = s_nationkey and s_nationkey = n_nationkey and n_regionkey = r_regionkey and r_name = 'ASIA' and o_orderdate >= date ('1994-1-1') and o_orderdate < date ('1994-1-1') + interval '1' year group by n_name order by revenue desc;";
			break;
		case 6:
			sql = "select sum(l_extendedprice * l_discount) as revenue from lineitem where l_shipdate >= date ('1994-1-1') and l_shipdate < date ('1994-1-1') + interval '1' year and l_discount between 0.06 - 0.01 and 0.06 + 0.01 and l_quantity < 24;";
			break;
		case 7:
			sql = "select supp_nation,cust_nation,l_year,sum(volume) as revenue from ( select n1.n_name as supp_nation,n2.n_name as cust_nation,extract(year from l_shipdate) as l_year,l_extendedprice * (1 - l_discount) as volume from supplier,lineitem,orders,customer,nation n1,nation n2 where s_suppkey = l_suppkey and o_orderkey = l_orderkey and c_custkey = o_custkey and s_nationkey = n1.n_nationkey and c_nationkey = n2.n_nationkey and ((n1.n_name = 'FRANCE' and n2.n_name = 'GERMANY') or (n1.n_name = 'GERMANY' and n2.n_name = 'FRANCE')) and l_shipdate between date ('1995-01-01') and date ('1996-12-31')) as shipping group by supp_nation,cust_nation,l_year order by supp_nation,cust_nation,l_year;";
			break;
		case 8:
			sql = "select o_year,sum(case when nation = 'BRAZIL' then volume else 0 end) / sum(volume) as mkt_share from (select extract(year from o_orderdate) as o_year,l_extendedprice * (1 - l_discount) as volume,n2.n_name as nation from part,supplier,lineitem,orders,customer,nation n1,nation n2,region where p_partkey = l_partkey and s_suppkey = l_suppkey and l_orderkey = o_orderkey and o_custkey = c_custkey and c_nationkey = n1.n_nationkey and n1.n_regionkey = r_regionkey and r_name = 'AMERICA' and s_nationkey = n2.n_nationkey and o_orderdate between date ('1995-01-01') and date ('1996-12-31') and p_type = 'ECONOMY ANODIZED STEEL') as all_nations group by o_year order by o_year;";
			break;
		case 9:
			sql = "select nation,o_year,sum(amount) as sum_profit from( select n_name as nation,extract(year from o_orderdate) as o_year,l_extendedprice * (1 - l_discount) - ps_supplycost * l_quantity as amount from part,supplier,lineitem,partsupp,orders,nation where s_suppkey = l_suppkey and ps_suppkey = l_suppkey and ps_partkey = l_partkey and p_partkey = l_partkey and o_orderkey = l_orderkey and s_nationkey = n_nationkey and p_name like '%green%') as profit group by nation,o_year order by nation,o_year desc;";
			break;
		case 10:
			sql = "select c_custkey,c_name,sum(l_extendedprice * (1 - l_discount)) as revenue,c_acctbal,n_name,c_address,c_phone,c_comment from customer,orders,lineitem,nation where c_custkey = o_custkey and l_orderkey = o_orderkey and o_orderdate >= date ('1993-10-1') and o_orderdate < date ('1994-1-1') and l_returnflag = 'R' and c_nationkey = n_nationkey group by c_custkey,c_name,c_acctbal,c_phone,n_name,c_address,c_comment order by revenue desc;";
			break;
		case 11:
			sql = "select ps_partkey,sum(ps_supplycost * ps_availqty) as value from partsupp,supplier,nation where ps_suppkey = s_suppkey and s_nationkey = n_nationkey and n_name = 'GERMANY' group by ps_partkey having sum(ps_supplycost * ps_availqty) > ( select sum(ps_supplycost * ps_availqty) * 0.0001 from partsupp,supplier,nation where ps_suppkey = s_suppkey and s_nationkey = n_nationkey and n_name = 'GERMANY') order by value desc;";
			break;
		case 12:
			sql = "select l_shipmode,sum(case when o_orderpriority = '1-URGENT' or o_orderpriority = '2-HIGH' then 1 else 0 end) as high_line_count, sum(case when o_orderpriority <> '1-URGENT' and o_orderpriority <> '2-HIGH' then 1 else 0 end) as low_line_count from orders,lineitem where o_orderkey = l_orderkey and l_shipmode in ('MAIL', 'SHIP') and l_commitdate < l_receiptdate and l_shipdate < l_commitdate and l_receiptdate >= date ('1994-1-1') and l_receiptdate < date ('1994-1-1') + interval '1' year group by l_shipmode order by l_shipmode;";
			break;
		case 13:
			sql = "select c_count,count(*) as custdist from ( select c_custkey,count(o_orderkey) from customer left outer join orders on c_custkey = o_custkey and o_comment not like '%special%requests%' group by c_custkey) as c_orders (c_custkey, c_count) group by c_count order by custdist desc,c_count desc;";
			break;
		case 14:
			sql = "select 100.00 * sum(case when p_type like 'PROMO%' then l_extendedprice * (1 - l_discount) else 0 end) / sum(l_extendedprice * (1 - l_discount)) as promo_revenue from lineitem,part where l_partkey = p_partkey and l_shipdate >= date ('1995-9-1') and l_shipdate < date ('1995-9-1') + interval '1' month;";
			break;
		case 15:
			sql = "select * from region";
			break;
		case 16:
			sql = "select p_brand,p_type,p_size,count(distinct ps_suppkey) as supplier_cnt from partsupp,part where p_partkey = ps_partkey and p_brand <> 'Brand#45' and p_type not like 'MEDIUM POLISHED%' and p_size in (49, 14, 23, 45, 19, 3, 36, 9) and ps_suppkey not in ( select s_suppkey from supplier where s_comment like '%Customer%Complaints%') group by p_brand,p_type,p_size order by supplier_cnt desc,p_brand,p_type,p_size;";
			break;
		case 17:
			sql = "select * from region";
			break;
		case 18:
			sql = "select c_name,c_custkey,o_orderkey,o_orderdate,o_totalprice,sum(l_quantity) from customer,orders,lineitem where o_orderkey in ( select l_orderkey from lineitem group by l_orderkey having sum(l_quantity) > 300) and c_custkey = o_custkey and o_orderkey = l_orderkey group by c_name,c_custkey,o_orderkey,o_orderdate,o_totalprice order by o_totalprice desc,o_orderdate;";
			break;
		case 19:
			sql = "select sum(l_extendedprice* (1 - l_discount)) as revenue from lineitem,part where ( p_partkey = l_partkey and p_brand = 'Brand#12' and p_container in ('SM CASE', 'SM BOX', 'SM PACK', 'SM PKG')  and l_quantity >= 1 and l_quantity <= 1 + 10 and p_size between 1 and 5 and l_shipmode in ('AIR', 'AIR REG') and l_shipinstruct = 'DELIVER IN PERSON') or (p_partkey = l_partkey and p_brand = 'Brand#23' and p_container in ('MED BAG', 'MED BOX', 'MED PKG', 'MED PACK') and l_quantity >= 10 and l_quantity <= 10 + 10 and p_size between 1 and 10 and l_shipmode in ('AIR', 'AIR REG') and l_shipinstruct = 'DELIVER IN PERSON') or ( p_partkey = l_partkey and p_brand = 'Brand#34' and p_container in ('LG CASE', 'LG BOX', 'LG PACK', 'LG PKG') and l_quantity >= 20 and l_quantity <= 20 + 10 and p_size between 1 and 15 and l_shipmode in ('AIR', 'AIR REG') and l_shipinstruct = 'DELIVER IN PERSON');";
			break;
		case 20:
			sql = "select * from region";
			break;
		case 21:
			sql = "select s_name,count(*) as numwait from supplier,lineitem l1,orders,nation where s_suppkey = l1.l_suppkey and o_orderkey = l1.l_orderkey and o_orderstatus = 'F' and l1.l_receiptdate > l1.l_commitdate and exists ( select * from lineitem l2 where l2.l_orderkey = l1.l_orderkey and l2.l_suppkey <> l1.l_suppkey ) and not exists ( select * from lineitem l3 where l3.l_orderkey = l1.l_orderkey and l3.l_suppkey <> l1.l_suppkey and l3.l_receiptdate > l3.l_commitdate ) and s_nationkey = n_nationkey and n_name = 'SAUDI ARABIA' group by s_name order by numwait desc,s_name;";
			break;
		case 22:
			sql = "select cntrycode,count(*) as numcust,sum(c_acctbal) as totacctbal from ( select substring(c_phone from 1 for 2)  as cntrycode,c_acctbal from customer where substring(c_phone from 1 for 2) in ('13', '31', '23', '29', '30', '18', '17') and c_acctbal > ( select avg(c_acctbal) from customer where c_acctbal > 0.00 and substring(c_phone from 1 for 2)  in ('13', '31', '23', '29', '30', '18', '17') ) and not exists ( select * from orders where o_custkey = c_custkey ) ) as custsale group by cntrycode order by cntrycode;";
			break;
		case 23:
			sql="select count(r_name) as all_regionName from probe;";
			break;
		case 24:
			sql="select count(l_quantity) as all_quantity from probe;";
			break;
		case 25:
			sql="select l_tax as tax from probe;";
			break;
		default:
			sql = "";
			break;
		}
		return sql;
	}

	public String qid2snap(int qid) {
		// TODO Auto-generated method stub
		String sql = null;
		String Kquery01 = "'%sum_qty%'";//2484956041
		String Kquery02 = "'%p_mfgr%'";//1857163664
		String Kquery03 = "'%c_mktsegment%'";//1659949904
		String Kquery04 = "'%order_count%'";//150577201
		String Kquery05 = "'%sum(l_extendedprice%'";//757179007
		String Kquery06 = "'%* l_discount%'";//2656261206
		String Kquery07 = "'%as supp_nation%'";//2861367177
		String Kquery08 = "'%mkt_share%'";//2429570527
		String Kquery09 = "'%sum_profit%'";//4034004143
		String Kquery10 = "'%l_returnflag =%'";//41028573
		String Kquery11 = "'%* ps_availqty%'";//3478414336
		String Kquery12 = "'% o_orderpriority%'";//3037488137
		String Kquery13 = "'%custdist%'";//3775286054
		String Kquery14 = "'%promo_revenue%'";//468934169
		String Kquery15 = "'%region'";
		String Kquery16 = "'%supplier_cnt%'";//4259549101
		String Kquery17 = "'%region'";
		String Kquery18 = "'%o_totalprice%'";//128148866
		String Kquery19 = "'%l_shipinstruct%'";//2863695079
		String Kquery20 = "'%region'";
		String Kquery21 = "'%numwait%'";//3702901097
		String Kquery22 = "'%numcust%'";//2993907557
		String Kquery23 = "'%all_regionName%'";//845041191
		String Kquery24 = "'%all_quantity%'";//3986307502
		String Kquery25 = "'%tax%'";//1394219740
		String condition1 = " and queryid=2484956041";
		String condition2 = " and queryid=1857163664";
		String condition3 = " and queryid=1659949904";
		String condition4 = " and queryid=150577201";
		String condition5 = " and queryid=757179007";
		String condition6 = " and queryid=2656261206";
		String condition7 = " and queryid=2861367177";
		String condition8 = " and queryid=2429570527";
		String condition9 = " and queryid=4034004143";
		String condition10 = " and queryid=41028573";
		String condition11 = " and queryid=3478414336";
		String condition12 = " and queryid=3037488137";
		String condition13 = " and queryid=3775286054";
		String condition14 = " and queryid=468934169";
		String condition15 = " limit 1";
		String condition16 = " and queryid=4259549101";
		String condition17 = " limit 1";
		String condition18 = " and queryid=128148866";
		String condition19 = " and queryid=2863695079";
		String condition20 = " limit 1";
		String condition21 = " and queryid=3702901097";
		String condition22 = " and queryid=2993907557";
		String condition23 = " and queryid=845041191";
		String condition24 = " and queryid=3716995007";
		String condition25 = " and queryid=1394219740";
		String temp = "select queryid,userid,dbid,calls,total_time,rows,shared_blks_hit,shared_blks_read,shared_blks_dirtied,shared_blks_written,local_blks_hit,local_blks_read,local_blks_dirtied,local_blks_written,temp_blks_read,temp_blks_written,blk_read_time,blk_write_time  from pg_stat_statements where dbid = "+dbid +" and query like ";
		switch (qid) {
		case 1:
			sql = temp + Kquery01 + condition1;
			break;
		case 2:
			sql = temp + Kquery02 + condition2;
			break;
		case 3:
			sql = temp + Kquery03 + condition3;
			break;
		case 4:
			sql = temp + Kquery04 + condition4;
			break;
		case 5:
			sql = temp + Kquery05 + condition5;
			break;
		case 6:
			sql = temp + Kquery06 + condition6;
			break;
		case 7:
			sql = temp + Kquery07 + condition7;
			break;
		case 8:
			sql = temp + Kquery08 + condition8;
			break;
		case 9:
			sql = temp + Kquery09 + condition9;
			break;
		case 10:
			sql = temp + Kquery10 + condition10;
			break;
		case 11:
			sql = temp + Kquery11 + condition11;
			break;
		case 12:
			sql = temp + Kquery12 + condition12;
			break;
		case 13:
			sql = temp + Kquery13 + condition13;
			break;
		case 14:
			sql = temp + Kquery14 + condition14;
			break;
		case 15:
			sql = temp + Kquery15 + condition15;
			break;
		case 16:
			sql = temp + Kquery16 + condition16;
			break;
		case 17:
			sql = temp + Kquery17 + condition17;
			break;
		case 18:
			sql = temp + Kquery18 + condition18;
			break;
		case 19:
			sql = temp + Kquery19 + condition19;
			break;
		case 20:
			sql = temp + Kquery20 + condition20;
			break;
		case 21:
			sql = temp + Kquery21 + condition21;
			break;
		case 22:
			sql = temp + Kquery22 + condition22;
			break;
		case 23:
			sql = temp + Kquery23 + condition23;
			break;
		case 24:
			sql = temp + Kquery24 + condition24;
			break;
		case 25:
			sql = temp + Kquery25 + condition25;
			break;
		default:
			sql = "";
			break;
		}
		return sql;
	}

}
