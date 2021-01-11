1.用户表(User)

| 字段名           | 属性        | 描述       | 备注       |
| ---------------- | ----------- | ---------- | ---------- |
| userid           | int         | 用户ID     | 主键自增长 |
| username         | Varchar(20) | 用户账号   |            |
| userpass         | Varchar(20) | 用户密码   |            |
| uphone           | Varchar(20) | 手机号     |            |
| sex              | char        | 性别       |            |
| age              | short       | 年龄       |            |
| ChinaName        | Varchar(20) | 身份证姓名 |            |
| chinaId          | Varchar(18) | 身份证号码 |            |
| address          | Varchar(50) | 家庭地址   |            |
| Nation           | Varchar(10) | 民族       |            |
| 用于用户登录注册 |             |            |            |

2.全国地址表（city）

| 字段名      | 属性         | 描述       | 备注 |      |
| ----------- | ------------ | ---------- | ---- | ---- |
| cid         | int          | 全国地址id |      |      |
| code        | varchar(50)  | 地区编号   |      |      |
| cname       | varchar(255) | 地区名字   |      |      |
| parentId    | int          |            |      |      |
| firstLetter | varchar(10)  |            |      |      |
| level       | int          |            |      |      |



3.地址表（address）

| 字段名                 | 属性         | 描述     | 备注       |
| ---------------------- | ------------ | -------- | ---------- |
| aid                    | int(11)      | 地址表id | 主键自增长 |
| aname                  | varchar(50)  | 姓名     |            |
| phone                  | varchar(11)  | 手机     |            |
| phoneSpecial           | varchar(11)  | 座机号   |            |
| alevel                 | varchar(100) | 省市区   |            |
| detail                 | varchar(255) | 详细地址 |            |
| userid                 | int(11)      | 用户id   | 用户id外键 |
| 用于账号管理的地址中心 |              |          |            |

4.寄件人表（sender）

| 字段名                       | 属性         | 描述             | 备注       |
| ---------------------------- | ------------ | ---------------- | ---------- |
| seid                         | int          | 下单id           | 主键自增长 |
| sname                        | Varchar(50)  | 寄件人姓名       |            |
| saddress                     | Varchar(255) | 寄件人地址       |            |
| slandline                    | Varchar(255) | 寄件人座机号     |            |
| sphone                       | Varchar(255) | 寄件人手机号     |            |
| sdetailedAddress             | Varchar(255) | 寄件人详细地址   |            |
| spayment                     | Varchar(255) | 寄件人付款的方式 |            |
| sEMail                       | Varchar(255) | 邮箱             |            |
| senderTime                   | varchar(255) | 寄件时间         |            |
| 用于在线寄件页面的寄件人信息 |              |                  |            |

5.收件人表（recipients）

| 字段名                     | 属性         | 描述           | 备注                                                         |
| -------------------------- | ------------ | -------------- | ------------------------------------------------------------ |
| reid                       | Int(11)      | 收件人id       | 主键自增长                                                   |
| rName                      | Varchar(255) | 收件人姓名     |                                                              |
| rephone                    | Varchar(255) | 收件人手机号   |                                                              |
| readdress                  | Varchar(255) | 收件人地址     |                                                              |
| redetailedAddress          | Varchar(255) | 收件人详细地址 |                                                              |
| relandline                 | Varchar(255) | 收件人座机号   |                                                              |
| reweight                   | Int(11)      | 物品重量       |                                                              |
| retype                     | Varchar(255) | 物品类型       | 文件 ![img](file:///C:\Users\like\AppData\Local\Temp\ksohtml3100\wps1.png)服饰 ![img](file:///C:\Users\like\AppData\Local\Temp\ksohtml3100\wps2.png)食品 ![img](file:///C:\Users\like\AppData\Local\Temp\ksohtml3100\wps3.png)数码用品 ![img](file:///C:\Users\like\AppData\Local\Temp\ksohtml3100\wps4.png)生活用品 ![img](file:///C:\Users\like\AppData\Local\Temp\ksohtml3100\wps5.png)其他 |
| repredictTime              | Varchar(255) | 预计到达时间   |                                                              |
| rePredictPrice             | Varchar(255) | 预计价格       |                                                              |
| recTime                    | varchar(255) | 收件时间       |                                                              |
| 用于在线寄件页面的收件人表 |              |                |                                                              |

6.取件表（pickUp）

| 字段名    | 属性         | 描述             | 备注       |
| --------- | ------------ | ---------------- | ---------- |
| picid     | int(11)      | 取件id           | 主键自增长 |
| seid      | int          | 寄件人id         |            |
| coding    | varchar(255) | 取件码           |            |
| starttime | Varchar(255) | 上门取件时间开始 |            |
| stoptime  | varchar      | 上门取件截止时间 |            |
| remark    | Varchar(255) | 备注             |            |
|           |              |                  |            |
|           |              |                  |            |

7.订单表（orders）

| 字段名      | 属性         | 描述     | 备注                                        |
| ----------- | ------------ | -------- | ------------------------------------------- |
| oid         | Int(11)      | 订单id   | 主键自增长                                  |
| reid        | Int(11)      | 收件人id |                                             |
| seid        | int          | 寄件人id |                                             |
| Weight      | double       | 物品重量 |                                             |
| Amount      | double       | 支付金额 |                                             |
| Amountstate | int          | 支付状态 | 未支付 已支付 未支付货到付款 已支付货到付款 |
| downTime    | varchar(255) | 下单时间 |                                             |
| state       | int(11)      | 状态     | 1.已处理 2.未处理 3。处理中                 |
| wayid       | int()        | 运单id   |                                             |

8.收费方式表（charge)

| 字段名      | 属性         | 描述         | 备注       |
| ----------- | ------------ | ------------ | ---------- |
| chid        | Int(11)      | 收费方式id   | 主键自增长 |
| commence    | Varchar(255) | 始发地       |            |
| those       | varchar(255) | 目的地       |            |
| goods       | Varchar(100) | 物品重量     |            |
| chargeTime  | Varchar(255) | 日期         |            |
| price       | Varchar(50)  | 现付参考价格 |            |
| predictTime | Varchar(255) | 预计到达时间 |            |

9.线路管理表（line）

| 字段名   | 属性    | 描述     | 备注                                            |
| -------- | ------- | -------- | ----------------------------------------------- |
| lid      | int(11) | 线路id   | 主键自增长                                      |
| line     | int(11) | 线路类型 | 1。全部 2。干线 3。周边 4。省内 5。临时 6。市内 |
| linename | varchar | 线路名称 |                                                 |
| linepath | varchar | 路径     |                                                 |



10.货车线路表（freight）

| 字段名 | 属性 | 描述       | 备注       |
| ------ | ---- | ---------- | ---------- |
| tlid   | int  | 货车线路id | 主键自增长 |
| trid   | int  | 货车id     |            |
| lid    | int  | 线路id     |            |



11.货车管理表（trucks)

| 字段名         | 属性         | 描述     | 备注                 |
| -------------- | ------------ | -------- | -------------------- |
| Trid           | Int(11)      | 货车id   | 主键自增长           |
| Vehicle choice | Int(11)      | 车辆选择 | 1.货车 2.火车 3.班车 |
| license        | Varchar(100) | 车牌号   | 手工录入             |
| commonCarrier  | Varchar(100) | 承运商   | 自动                 |
| control        | varchar(500) | 吨控     | 货车的重量限制       |



12.货车司机表(driver)

| 字段名       | 属性 | 描述       | 备注           |
| ------------ | ---- | ---------- | -------------- |
| tcid         | int  | 货车司机id | 主键自增长     |
| trid         | int  | 货车id     | 货车管理表的id |
| chanuffeurid | int  | 司机id     | 司机表id       |



13.司机表(chauffeur)

| 字段名             | 属性    | 描述                      | 备注       |
| ------------------ | ------- | ------------------------- | ---------- |
| chauffeurid        | int     | 司机id                    | 主键自增长 |
| chauffeurname      | varchar | 司机名字                  |            |
| chauffeurage       | int     | 司机年龄                  |            |
| chauffeursex       | char    | 司机性别                  |            |
| chauffeurphone     | varchar | 司机电话                  |            |
| chauffeurcard      | varchar | 身份证                    |            |
| chauffeuraddress   | varchar | 司机住址                  |            |
| chauffeurSeniority | int     | 司机工龄                  |            |
| chauffeurstate     | int     | 司机状态 (在职 休假 退休) |            |

14.快递员表（courier）

| 字段名      | 属性         | 描述         | 备注       |
| ----------- | ------------ | ------------ | ---------- |
| courid      | int          | 快递员id     | 主键自增长 |
| userid      | int          | 用户id       | 外键       |
| couname     | varchar(255) | 快递员名字   |            |
| workNumber  | varchar(255) | 快递员工单号 |            |
| phoneNumber | varchar(255) | 快递员电话   |            |
| couAddress  | varchar(255) | 快递员地址   |            |

15.投诉表（complaint）

| 字段名    | 属性         | 描述            | 备注                 |
| --------- | ------------ | --------------- | -------------------- |
| coid      | int          | 投诉id          | 主键自增长           |
| uerid     | int          | 用户id          |                      |
| oid       | int          | 运单号 订单号id | 外键                 |
| comrole   | varchar(255) | 录入人角色      |                      |
| comname   | varchar(255) | 录入人姓名      |                      |
| comphone  | varchar(11)  | 录入人手机      |                      |
| workType  | varchar(255) | 工单类型        | 不送货上门  服务行为 |
| inName    | varchar(255) | 内件品名        |                      |
| feedback  | varchar(255) | 反馈内容        |                      |
| uploadimg | varchar(500) | 上传附件        |                      |

16.评论表（comment）

| 字段名  | 属性         | 描述       | 备注       |
| ------- | ------------ | ---------- | ---------- |
| coid    | Int(11)      | 评论id     | 主键自增长 |
| userid  | int          | 用户id     |            |
| content | Varchar(255) | 评论的内容 |            |
| grade   | Varchar(255) | 评论等级   |            |
| oserial | Varchar(255) | 订单编号   |            |

17.仓库表（TotalWarehouse）

| 字段名 | 属性         | 描述                                     | 备注       |
| ------ | ------------ | ---------------------------------------- | ---------- |
| Twid   | Int(11)      | 仓库id                                   | 主键自增长 |
| twname | Varchar(20)  | 操作人员姓名                             |            |
| twtime | Varchar(255) | 时间                                     |            |
| state  | Int(11)      | 状态                                     |            |
| code   | Varchar(255) | 根据地区行政代码来区分是省包裹还是市包裹 |            |

18.网点信息表（branch）

| 字段名          | 属性         | 描述         | 备注       |
| --------------- | ------------ | ------------ | ---------- |
| brid            | Int(11)      | 网点id       | 主键自增长 |
| branchName      | Varchar(20)  | 网点名称     |            |
| brName          | Varchar(20)  | 管理员姓名   |            |
| brpone          | Varchar(11)  | 查询电话     |            |
| postcode        | Varchar(20)  | 邮编         |            |
| business        | Varchar(255) | 业务区域     |            |
| branchType      | Varchar(255) | 网点类型     |            |
| IDnumber        | Varchar(255) | 身份证号     |            |
| unusualPone     | Varchar(255) | 异常查件电话 |            |
| nextNumber      | Varchar(255) | 下一站编号   |            |
| Subordinate     | Varchar(255) | 所属省区     |            |
| brNumberPone    | Varchar(255) | 手机号       |            |
| workAddress     | Varchar(255) | 办公地址     |            |
| applicationDate | VARCHAR(255) | 申请时间     |            |
| approvaltime    | VARCHAR(255) | 审批时间     |            |
| examineresult   | VARCHAR(255) | 审批结果     |            |
| userid          | int          | 用户ID       | 外键       |

19.管理员表（admin）

| 字段名       | 属性         | 描述       | 备注       |
| ------------ | ------------ | ---------- | ---------- |
| adminid      | Int(11)      | 管理员id   | 主键自增长 |
| adminname    | Varchar(20)  | 管理员名字 |            |
| adminpass    | Varchar(20)  | 管理员密码 |            |
| compellation | Varchar(10)  | 名称       |            |
| adminimg     | Varchar(500) | 头像       |            |
| Groupid      | int          | 组id       |            |
| state        | int          | 状态       |            |

20.管理员角色表（adminrole）

| 字段名    | 属性      | 描述     | 备注       |
| --------- | --------- | -------- | ---------- |
| adminrole | Int       | 角色id   | 主键自增长 |
| Adminid   | Int（11） | 管理员id |            |
| roleid    | int       | 角色     |            |

21.分组表(group)

| 字段名     | 属性        | 描述     | 备注       |
| ---------- | ----------- | -------- | ---------- |
| groupid    | Int         | 角色组id | 主键自增长 |
| groundname | Varchar(50) | 组名称   |            |
| roleid     | int         | 角色     |            |

22.角色表（roleinfo）

| 字段名    | 属性        | 描述     | 备注       |
| --------- | ----------- | -------- | ---------- |
| roleid    | Int(11)     | 角色id   | 主键自增长 |
| rolename  | varchar(50) | 角色名字 |            |
| rolestate | int         | 角色状态 |            |

23.角色菜单表（rolemenu）

| 字段名   | 属性 | 描述       | 备注     |
| -------- | ---- | ---------- | -------- |
| rolemenu | Int  | 角色菜单id | 主键增长 |
| roleid   | int  | 角色id     |          |
| menuid   | int  | 菜单id     |          |

24.菜单表（menuinfo）

| 字段名    | 属性         | 描述             | 备注 |
| --------- | ------------ | ---------------- | ---- |
| menuid    | varchar      | 菜单的id         |      |
| Title     | Varchar(20)  | 菜单的名字       |      |
| menustate | Int          | 菜单的状态       |      |
| url       | Varchar(200) | 路劲             |      |
| Previd    | Varchar(20)  | 上级id           |      |
| iconCls   | Varchar(20)  | 菜单项显示的图标 |      |
