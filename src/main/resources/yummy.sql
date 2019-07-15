use yummy;

start transaction;
insert into food_state(name) values ('normal');

insert into food_state(name) values ('empty');

insert into food_state(name) values ('cancel');

insert into restaurant_state(name) values ('normal');

insert into restaurant_state(name) values ('examine');

insert into restaurant_state(name) values ('fail');

insert into member_state(name) values ('normal');

insert into member_state(name) values ('cancel');

insert into order_state(name) values ('unpaid');

insert into order_state(name) values ('cancel');

insert into order_state(name) values ('done');

insert into order_state(name) values ('paid');

insert into order_state(name) values ('assessed');
commit ;

start transaction;
insert into bank_account(account_id, balance, password) VALUES ('4000000000000001',1000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('4000000000000002',1000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('4000000000000003',1000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('4000000000000004',1000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('4000000000000005',1000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('4000000000000006',1000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('4000000000000007',1000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('4000000000000008',1000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('4000000000000009',1000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('4000000000000010',1000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('5000000000000001',10000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('5000000000000002',10000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('5000000000000003',10000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('5000000000000004',10000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('5000000000000005',10000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('5000000000000006',10000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('5000000000000007',10000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('5000000000000008',10000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('5000000000000009',10000,'123456');

insert into bank_account(account_id, balance, password) VALUES ('5000000000000010',10000,'123456');

insert into restaurant(rid,account_id,address,announcement,city,deliver_price,email,lat,lng,name,
                       password,phone,picture,starting_price,total_discount,restaurant_state_name,restaurant_type_type_id)
VALUES ('rest001','4000000000000001','南京市秦淮区三条巷18号2F12-1商铺','米饭需要单点哦','南京市',3,'aishangmalaxiangguo@163.com',
                  32.04,118.80,'爱尚麻辣香锅','-sj9c4892d9c7lisb7bdfscnic7jo2haauag1gqurvfjdn2i74re','80080001',
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/avatar.webp',20,1,'normal',3);

insert into restaurant(rid,account_id,address,announcement,city,deliver_price,email,lat,lng,name,
                       password,phone,picture,starting_price,total_discount,restaurant_state_name,restaurant_type_type_id)
VALUES ('rest002','4000000000000002','南京市北京东路4号广电城二期贰层206室','该商家支持开发票，请在下单时填写好发票抬头','南京市',0.5,'hanbaowang@163.com',
                  32.065,118.795,'汉堡王（南京电视台店）','-sj9c4892d9c7lisb7bdfscnic7jo2haauag1gqurvfjdn2i74re','80082322',
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/hanbaowang/hanbaowang.webp',25,1,'normal',1);

insert into restaurant(rid,account_id,address,announcement,city,deliver_price,email,lat,lng,name,
                       password,phone,picture,starting_price,total_discount,restaurant_state_name,restaurant_type_type_id)
VALUES ('rest003','4000000000000003','南京市秦淮区汉中路89号金鹰国际购物中心B座负一层LG1-001','①本店电子发票，不含配送费，敬请谅解 ②备注若未及时关注到，敬请谅解','南京市',3,'shiqijia@163.com',
                  32.05,118.79,'食其家（新街口金鹰店）','-sj9c4892d9c7lisb7bdfscnic7jo2haauag1gqurvfjdn2i74re','83321754',
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/shiqijia/shiqijia.webp',20,1,'normal',3);

insert into restaurant(rid,account_id,address,announcement,city,deliver_price,email,lat,lng,name,
                       password,phone,picture,starting_price,total_discount,restaurant_state_name,restaurant_type_type_id)
VALUES ('rest004','4000000000000004','南京市玄武区北京东路1号','轻食物语沙拉始终保持着初心、用心做沙拉、让用户吃的放心、安心、健康','南京市',1,'qingshiwuyu@163.com',
                  32.057,118.788,'Vagetale轻食物语沙拉','-sj9c4892d9c7lisb7bdfscnic7jo2haauag1gqurvfjdn2i74re','83486750',
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/qingshiwuyu/qingshiwuyu.webp',15,1,'normal',6);

insert into restaurant(rid,account_id,address,announcement,city,deliver_price,email,lat,lng,name,
                       password,phone,picture,starting_price,total_discount,restaurant_state_name,restaurant_type_type_id)
VALUES ('rest005','4000000000000005','南京市鼓楼区广州路5号2幢106室','永和大王！台式好味道！如您遇到不满意的就餐体验，希望不要着急给到差评，可以拨打客服热线：4000979797，我们的服务一定会让您满意！','南京市',3.5,'yonghedawang@163.com',
                  32.065,118.79,'永和大王(广州路店)','-sj9c4892d9c7lisb7bdfscnic7jo2haauag1gqurvfjdn2i74re','4000979797',
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/yonghedawang/yonghedawang.webp',20,1,'normal',1);

insert into restaurant(rid,account_id,address,announcement,city,deliver_price,email,lat,lng,name,
                       password,phone,picture,starting_price,total_discount,restaurant_state_name,restaurant_type_type_id)
VALUES ('rest006','4000000000000006','玄武区中央路大钟亭1号','大薯条或薯格买一送一限时优惠，同时全新推出和风牛丼饭套餐，更有多款下午茶套餐，伴你度过悠然的下午时光，美味缤纷停不下来！','南京市',9,'maidanglao@163.com',
                  32.059,118.788,'南京麦当劳大钟亭餐厅','-sj9c4892d9c7lisb7bdfscnic7jo2haauag1gqurvfjdn2i74re','4000517517',
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/maidanglao/maidanglao.webp',30,1,'normal',3);

insert into restaurant(rid,account_id,address,announcement,city,deliver_price,email,lat,lng,name,
                       password,phone,picture,starting_price,total_discount,restaurant_state_name,restaurant_type_type_id)
VALUES ('rest007','4000000000000007','南京市玄武区珠江路1号金鹰天地购物中心1层105室T101商铺','感谢您选择Mr.Pizza~','南京市',0.5,'misite@163.com',
                  32.065,118.793,'米斯特比萨(南京珠江路店）','-sj9c4892d9c7lisb7bdfscnic7jo2haauag1gqurvfjdn2i74re','89847105',
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/misite/misite.webp',30,1,'normal',2);

insert into restaurant(rid,account_id,address,announcement,city,deliver_price,email,lat,lng,name,
                       password,phone,picture,starting_price,total_discount,restaurant_state_name,restaurant_type_type_id)
VALUES ('rest008','4000000000000008','南京市玄武区新街口街道大纱帽巷38号1幢107室','','南京市',0,'pengdekai@163.com',
                  32.065,118.795,'彭德楷黄焖鸡米饭(珠江路店)','-sj9c4892d9c7lisb7bdfscnic7jo2haauag1gqurvfjdn2i74re','89321105',
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/pengdekai/pengdekai.webp',15,1,'normal',1);

insert into restaurant(rid,account_id,address,announcement,city,deliver_price,email,lat,lng,name,
                       password,phone,picture,starting_price,total_discount,restaurant_state_name,restaurant_type_type_id)
VALUES ('rest009','4000000000000009','南京市玄武区新街口街道珠江路88号新世界百货二层892号','本店店主是个宠客狂魔，各位小哥哥小姐姐在用餐的过程中如果遇到食材不新鲜，不合自己的口味，食物中有异物，食物有漏洒，骑手态度差，配送时间长等等问题一定要先联系店主，所有问题就让店主来一一为你解决！','南京市',0.5,'xianxiaoka@163.com',
                  32.068,118.791,'鲜小咖海鲜焖面','-sj9c4892d9c7lisb7bdfscnic7jo2haauag1gqurvfjdn2i74re','80467128',
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/xianxiaoka/xianxiaoka.webp',20,1,'normal',2);

insert into restaurant(rid,account_id,address,announcement,city,deliver_price,email,lat,lng,name,
                       password,phone,picture,starting_price,total_discount,restaurant_state_name,restaurant_type_type_id)
VALUES ('rest010','4000000000000010','北京市东城区王府井大街88号1幢地下一层B124、B125号','麦乐送专享买金拱门桶那么大组合送可口可乐弧形杯2个，同时推出新品可乐鸡翅，更多缤纷美味停不下来，店铺优惠与折扣不同享。','北京市',9,'beijingmdl@163.com',
                  39.99,116.31,'北京麦当劳王府井大街餐厅','-sj9c4892d9c7lisb7bdfscnic7jo2haauag1gqurvfjdn2i74re','66909234',
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/maidanglao/maidanglao.webp',30,1,'normal',3);
commit ;

start transaction;

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00001','主要原料：风味酱','微麻微辣（单人必点）',1000,0,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/la.webp',0.1,'必选品（单人必点）','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00002','主要原料：风味酱','中麻中辣（单人必点）',1000,0,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/la.webp',0.1,'必选品（单人必点）','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00003','主要原料：风味酱','变态麻变态辣（单人必点）',1000,0,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/la.webp',0.1,'必选品（单人必点）','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00004','主要原料：大米','米饭',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/mifan.webp',2,'必选品（单人必点）','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00101','主要原料：鹌鹑蛋','鹌鹑蛋',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/anchundan.webp',3,'香锅单点荤菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00102','主要原料：虾','大虾',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/daxia.webp',5,'香锅单点荤菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00103','主要原料：鹌鹑蛋','鹌鹑蛋',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/anchundan.webp',3,'香锅单点荤菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00104','主要原料：肥牛','肥牛',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/feiniu.webp',8,'香锅单点荤菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00105','主要原料：火腿肠','火腿肠',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/huotuichang.webp',3,'香锅单点荤菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00106','主要原料：鸡翅根','鸡翅根',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/jichi.webp',8,'香锅单点荤菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00107','主要原料：开花肠','开花肠',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/kaihuachang.webp',3.5,'香锅单点荤菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00108','主要原料：里脊','里脊',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/liji.webp',5,'香锅单点荤菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00109','主要原料：牛肉','牛柳',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/niuliu.webp',8,'香锅单点荤菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00110','主要原料：肥牛','牛肉卷',1000.5,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/niuroujuan.webp',8,'香锅单点荤菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00111','主要原料：午餐肉','午餐肉',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/wucanrou.webp',4,'香锅单点荤菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00112','主要原料：蟹柳','蟹柳',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/xieliu.webp',6,'香锅单点荤菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00113','主要原料：鱼豆腐','鱼豆腐',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/yudoufu.webp',6,'香锅单点素菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00201','主要原料：冬瓜','冬瓜',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/donggua.webp',2,'香锅单点素菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00202','主要原料：豆芽','豆芽',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/douya.webp',2,'香锅单点素菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00203','主要原料：海带','海带结',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/haidai.webp',4,'香锅单点素菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00204','主要原料：花菜','花菜',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/huacai.webp',3,'香锅单点素菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00205','主要原料：黄瓜','黄瓜',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/huanggua.webp',3,'香锅单点素菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00206','主要原料：金针菇','金针菇',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/jinzhengu.webp',4,'香锅单点素菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00207','主要原料：木耳','木耳',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/muer.webp',5,'香锅单点素菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00208','主要原料：生菜','生菜',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/shengcai.webp',3,'香锅单点素菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00209','主要原料：娃娃菜','娃娃菜',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/wawacai.webp',3,'香锅单点素菜类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00301','主要原料：豆腐','千叶豆腐',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/doufu.webp',3,'香锅单点豆制品类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00302','主要原料：腐竹','腐竹',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/fuzhu.webp',4,'香锅单点豆制品类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00303','主要原料：面筋包','面筋',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/mianjin.webp',3,'香锅单点豆制品类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00304','主要原料：香菇','香菇',1000,0.5,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/xianggu.webp',6,'香锅单点豆制品类','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00401','主要原料：培根+火腿肠+6个素菜+米饭','单人套餐A',1000,3,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/taocan.webp',21,'单人套餐','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00402','主要原料：培根+鱼豆腐+6个素菜+米饭','单人套餐B',1000,3,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/taocan.webp',21,'单人套餐','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00403','主要原料：牛肉丸+蟹肉棒+6个素菜+米饭','单人套餐C',1000,3,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/taocan.webp',21,'单人套餐','normal','rest001');

insert into food(fid, announcement, name, number, package_price, picture, price, type, food_state_name, restaurant_rid)
values ('food00404','主要原料：开花肠+牛柳+6个素菜+米饭','单人套餐D',1000,3,
        'https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/restaurant/malaxiangguo/taocan.webp',21,'单人套餐','normal','rest001');

commit;