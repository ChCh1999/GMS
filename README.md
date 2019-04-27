# GMS
//赵彪
关于数据类型
   1 GroupID是int型（'1'代表7-8年龄组,'2'代表9-10,'3'代表11-12）
   2 然后其他所有的ID均为String型
   3 初赛成绩，决赛成绩均为float型
   4 TDoc是String型，存储队伍提交文件的地址，非文件
   5 裁判归结于stuff表，非裁判无需填写IP,PID,SType是int型（'1'代表比赛未开始的裁判,'2'代表比赛开始的裁判,'3' 教练员信息）
   6 match表Sex int型（'1'男  '2' 女）Judge 判断比赛是否进行('0' 未开始 '1' 开始 '2' 比赛结束) 初始为0；
   7 SType 0表示没判的裁判 1表示判了的裁判   2小组裁判  3总裁判 4领队  5队医   6教练员 
关于初始化建表以及查询函数
   1 代表队表，运动员表完整建表
   2 裁判归属于stuff表,stuff表初始建表不传入IP PID,后续函数ModifyPID，ModifyIP对裁判的PID IP进行加入
   3 project表初始建表 不传 Count1 Count2 Count3（报名人数，参赛人数，成绩人数）PerGroupCount （每组人数）后续ModifyCount1 ModifyCount2 ModifyCount3 （人数进行增加操作）ModifyPerGroupCount（该函数不计算）
   4 gradegroup表开始没有CSCore,JScore(初赛，决赛成绩)
   5 查询函数一般返回一个数组，里面带有查询的内容  查询队伍各个运动员成绩，查询个人成绩（初赛，决赛）,裁判的IP,查询比赛是否完成，一个项目 检索所有组的姓名+编号


