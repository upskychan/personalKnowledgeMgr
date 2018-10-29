package com.jacky.study.test;

import java.util.HashMap;
import java.util.Map;

public class TestConstians {
	public static void main(String[] args) {
		String title = "中共十八大报告";
		System.out.println(title.contains("十八大"));
		
		String keywords = "国家信仰,成功学,价值观,制度保障,机制,传播,时代,经济,军事,金融危机";
		String[] arr = keywords.split("[;, 	\t]");
		System.out.println(arr);
		String str = "美国=0.400000~社会阶层=0.320000~基尼系数=0.270000~世贸组织=0.270000~货币战争=0.270000~战争=0.135000~货币=0.135000~经济全球化进程=0.240000~经济=0.080000~全球化=0.080000~进程=0.080000~所有制结构=0.230000~结构=0.115000~所有制=0.115000~中国特色社会主义=0.190000~公有制=0.190000~资本主义国家=0.180000~日本=0.180000~领导干部=0.170000~社会生活=0.170000~重要思想=0.170000~重要=0.085000~思想=0.085000~三个代表=0.170000~表扬=0.160000~为人民服务=0.160000~为人=0.053333~服务=0.053333~冲击=0.160000~计划经济=0.160000~民族工业=0.160000~二战=0.150000~三大差别=0.150000~发达国家=0.140000~熔化=0.130000~社会转型时期=0.130000~社会转型=0.065000~时期=0.065000~学习型党组织=0.130000~党组织=0.065000~学习型=0.065000~诞生=0.130000~半封建社会=0.130000~半封建=0.065000~社会=0.065000~分配方式=0.120000~分配=0.060000~方式=0.060000~政治优势=0.120000~政治=0.060000~优势=0.060000~社会结构=0.120000~民营企业=0.120000~执政能力=0.120000~执政=0.060000~能力=0.060000~就业压力=0.120000~就业=0.060000~压力=0.060000~北京交通=0.120000~腐败问题=0.120000~腐败分子=0.120000~腐败现象=0.120000~心理健康=0.120000~贫富差距=0.120000~共产党宣宣言=0.120000~宣言=0.040000~共产党=0.040000~毛泽东思想=0.120000~沃尔玛=0.120000~就业难=0.120000~出发点=0.110000~人口=0.110000~发展中国家=0.110000~崛起=0.110000~贸易战争=0.110000~贸易=0.055000~十五=0.110000~分析=0.110000~十月革命=0.110000~同学=0.110000~感动=0.110000~产生=0.110000~衬衣=0.100000~马克思列宁主义=0.100000~形而上学=0.100000~center=0.100000~匹配=0.100000~跑步=0.100000~大局=0.100000~思考=0.100000~百万=0.100000~大事=0.100000~司令部=0.100000~深圳=0.100000~零部件=0.100000~多极化和一极化=0.090000~多极化=0.030000~极化=0.030000~和一=0.030000~斡旋=0.090000~仲裁=0.090000~落脚点=0.090000~区长=0.090000~国际形势=0.090000~稀土战争=0.090000~稀土=0.045000~执政党=0.080000~临界点=0.080000~writer=0.080000~开采=0.080000~困难=0.080000~战略协作伙伴关系=0.080000~协作=0.026667~伙伴关系=0.026667~战略=0.026667~中国延安干部学院=0.080000~延安=0.026667~干部学院=0.026667~中国=0.026667~社会主义初级阶段=0.080000~哥伦布发现新大陆=0.080000~发现=0.026667~新大陆=0.026667~哥伦布=0.026667~当权派=0.080000~第一次世界大战=0.080000~马克思主义哲学=0.080000~马克思=0.040000~主义哲学=0.040000~安定=0.080000~事物=0.080000~产业结构=0.080000~大学党委书记=0.080000~党委书记=0.040000~大学=0.040000~重要组成部分=0.080000~组成部分=0.040000~收入分配机制=0.080000~收入=0.026667~机制=0.026667~自由资本主义=0.080000~资本主义=0.040000~自由=0.040000~资本主义道路=0.080000~道路=0.040000~思想政治建设=0.080000~建设=0.040000~思想政治=0.040000~朝鲜问题=0.080000~朝鲜=0.040000~问题=0.040000~大学生=0.080000~xml version=0.080000~xml=0.040000~version=0.040000~宋体=0.080000~科学发展观=0.080000~科学=0.040000~发展观=0.040000~共产党宣言=0.080000~可持续发展=0.080000~江泽民同志=0.080000~邓小平理论=0.080000~毛主席著作=0.080000~毛主席=0.040000~著作=0.040000~态势=0.080000~口号=0.080000~剥削者=0.080000~华侨=0.080000~城乡差别=0.080000~资金问题=0.070000~资金=0.035000~苍蝇蚊子=0.070000~苍蝇=0.035000~蚊子=0.035000~中国出口=0.070000~思想作风=0.070000~自我价值=0.070000~价值=0.035000~自我=0.035000~业务能力=0.070000~业务=0.035000~政治素质=0.070000~业务素质=0.070000~惨痛教训=0.070000~社会规律=0.070000~规律=0.035000~贫富差别=0.070000~差别=0.035000~贫富=0.035000~区域经济=0.070000~生活作风=0.070000~食品掺假=0.070000~食品=0.035000~掺假=0.035000~背景特点=0.070000~特点=0.035000~背景=0.035000~中介组织=0.070000~大学校长=0.070000~大学时期=0.070000~重大问题=0.070000~游戏规则=0.070000~出国留学=0.070000~出国=0.035000~留学=0.035000~言行举止=0.070000~秘密报告=0.070000~报告=0.035000~秘密=0.035000~文化商人=0.070000~文化=0.035000~商人=0.035000~工作优势=0.070000~工作=0.035000~外商投资=0.070000~就业问题=0.070000~改革成果=0.070000~成果=0.035000~改革=0.035000~孩子留学=0.070000~孩子=0.035000~经济条件=0.070000~条件=0.035000~和谐社会=0.070000~国际背景=0.070000~和谐世界=0.070000~和谐=0.035000~世界=0.035000~宣传思想=0.070000~宣传=0.035000~武装全党=0.070000~全党=0.035000~武装=0.035000~理论武装=0.070000~理论=0.035000~万里长城=0.070000~稀土生产=0.070000~生产=0.035000~旅游出行=0.070000~旅游=0.035000~出行=0.035000~心理问题=0.070000~心理=0.035000~工作重心=0.070000~重心=0.035000~关键时期=0.070000~滔天罪行=0.070000~休闲度假=0.070000~影响=0.070000~人民公社=0.070000~内讧=0.070000~加工费=0.070000~科学社会主义=0.070000~红头文件=0.070000~活跃=0.070000~空战=0.070000~裤腿=0.070000~朝鲜战争=0.070000~唯物辩证法=0.070000~蒋介石=0.070000~薄熙来=0.070000~记忆力=0.070000~焦裕禄=0.070000~蝙蝠衫=0.070000~好不好=0.070000~格局=0.070000~第二次世界大战=0.070000~精加工=0.070000~马克思主义一元化=0.070000~一元化=0.035000~马克思主义=0.035000~交通大学人文学院=0.070000~人文学院=0.035000~交通大学=0.035000~无产阶级劳苦大众=0.070000~劳苦大众=0.035000~无产阶级=0.035000~市场经济=0.070000~短裙=0.070000~外敌=0.070000~思想观念多元化=0.070000~多元化=0.035000~思想观念=0.035000~总书记=0.070000~商务部=0.070000~系列片=0.070000~四角=0.070000~待会=0.070000~要死=0.070000~韩流=0.070000~澳洲=0.070000~商机=0.070000~矿难=0.070000~华约=0.070000~北约=0.070000~唐装=0.070000~贸易顺差=0.070000~超级大国=0.070000~思想文化思潮=0.070000~思潮=0.023333~胜利=0.070000~按劳分配=0.060000~新民主主义革命=0.060000~老祖宗=0.060000~时势=0.060000~政治多极化=0.060000~工农兵学商=0.060000~兵学=0.020000~工农=0.020000~内乱=0.060000~计算机网络=0.060000~团结=0.060000~童工=0.060000~加班加点=0.060000~围堵=0.060000~土地资源=0.060000~创业者=0.060000~购买力=0.060000~痛恨腐败=0.060000~腐败=0.030000~痛恨=0.030000~教育人民=0.060000~人民=0.030000~教育=0.030000~信息量=0.060000~航海=0.060000~灯塔=0.060000~生命线=0.060000~孤岛=0.060000~殖民地=0.060000~本科生=0.060000~赣州=0.060000~总统=0.060000~西服=0.060000~花架子=0.060000~关节=0.060000~倾销=0.060000~对峙=0.060000~早餐=0.060000~个体户=0.060000~青年人=0.060000~两极=0.060000~鼠标=0.060000~创新=0.060000~代表大会=0.060000~喇叭=0.060000~维护=0.060000~上海=0.060000~通商=0.060000~社会主义建设=0.060000~外债=0.060000~存储=0.060000~倒闭=0.060000~外企=0.060000~外币=0.060000~大家庭=0.060000~外国人=0.060000~澳币=0.060000~矿山=0.050000~娃娃=0.050000~管理人员=0.050000~建设者=0.050000~债券=0.050000~奖惩=0.050000~老家=0.050000~上课=0.050000~文革=0.050000~航线=0.050000~中小企业=0.050000~摇篮=0.050000~老挝=0.050000~研究生=0.050000~金属=0.050000~国务卿=0.050000~形式主义=0.050000~聪明=0.050000~报酬=0.050000~分解=0.050000~海湾=0.050000~换位=0.050000~劳动者=0.050000~惩罚=0.050000~演变=0.050000~战场=0.050000~看病=0.050000~动荡=0.050000~区委=0.050000~缓和=0.050000~世界观=0.050000~上班=0.050000~去世=0.050000~新加坡=0.050000~冷战=0.050000~下属=0.050000~工作作风=0.050000~攻坚=0.050000~真情=0.050000~外汇=0.050000~储备=0.050000~泰山=0.050000~古巴=0.050000~对比=0.050000~意大利=0.050000~心态=0.050000~background=0.050000~官方=0.050000~互联网=0.050000~主人=0.050000~健身=0.050000~主线=0.050000~加拿大=0.050000~战线=0.050000~失误=0.050000~缓解=0.050000~家乡=0.050000~读书=0.050000~color=0.050000~经济建设=0.050000~建国=0.050000~呼声=0.050000~中国人=0.050000~新时期=0.050000~分布=0.050000~住房=0.050000~维持=0.040000~真理=0.040000~平衡=0.040000~流通=0.040000~娱乐=0.040000~中华民族=0.040000~处罚=0.040000~道理=0.040000~邪教=0.040000~东方=0.040000~国情=0.040000~江西=0.040000~纽约=0.040000~飞机=0.040000~建党八十周年纪念大会=0.040000~周年=0.010000~八十=0.010000~纪念大会=0.010000~建党=0.010000~思想政治工作队伍的=0.040000~工作队=0.013333~伍的=0.013333~中间劳动密集型产业=0.040000~中间=0.013333~劳动密集型=0.013333~产业=0.013333~中国共产党成立八十=0.040000~中国共产党=0.013333~成立=0.013333~抵挡计算机信息网络=0.040000~计算机=0.013333~信息网络=0.013333~抵挡=0.013333~市长=0.040000~法国=0.040000~紧张=0.040000~德国=0.040000~公平正义失衡问题=0.040000~失衡=0.013333~公平正义=0.013333~垄断资本主义时期=0.040000~垄断资本主义=0.020000~延安干部学院学习=0.040000~学习=0.013333~意识形态领域斗争=0.040000~领域=0.013333~斗争=0.013333~意识形态=0.013333~思想政治宣传工作=0.040000~宣传工作=0.020000~社会主义国家苏联=0.040000~苏联=0.020000~社会主义国家=0.020000~科技革命日新月异=0.040000~日新月异=0.013333~革命=0.013333~科技=0.013333~社会主义应运而生=0.040000~应运而生=0.020000~社会主义=0.020000~修正主义人民群众=0.040000~人民群众=0.020000~修正主义=0.020000~改革开放打开窗户=0.040000~窗户=0.013333~开放打开=0.013333~台湾=0.040000~英国=0.040000~岗位=0.040000~政治思想工作=0.040000~环节=0.040000~友谊=0.040000~革命转到了和平=0.040000~和平=0.010000~到了=0.010000~公开推翻斯大林=0.040000~推翻=0.013333~斯大林=0.013333~公开=0.013333~国家领导人腐败=0.040000~国家=0.013333~领导人=0.013333~迎头赶上怎么办=0.040000~怎么办=0.020000~迎头赶上=0.020000~文化大革命总结=0.040000~总结=0.020000~文化大革命=0.020000~逼迫人民币升值=0.040000~逼迫=0.013333~人民币=0.013333~升值=0.013333~延安纪念张思德=0.040000~张思德=0.013333~纪念=0.013333~私营企业主队伍=0.040000~私营企业主=0.020000~队伍=0.020000~俄罗斯稀土储量=0.040000~俄罗斯=0.013333~储量=0.013333~多元化思维方式=0.040000~思维=0.013333~可不可以辩证法=0.040000~辩证法=0.020000~可不可以=0.020000~韩国=0.040000~广州=0.040000~生活方式变化=0.040000~变化=0.020000~生活方式=0.020000~周边搞好关系=0.040000~周边=0.020000~搞好关系=0.020000~经济学家发明=0.040000~发明=0.020000~经济学家=0.020000~报效父老乡亲=0.040000~报效=0.020000~父老乡亲=0.020000~成就举世瞩目=0.040000~成就=0.020000~举世瞩目=0.020000~生产要素分配=0.040000~生产要素=0.020000~方针政策路线=0.040000~方针政策=0.020000~路线=0.020000~人民利益服务=0.040000~人民利益=0.020000~共产主义天堂=0.040000~天堂=0.020000~共产主义=0.020000~共产主义信仰=0.040000~信仰=0.020000~民工流离失所=0.040000~流离失所=0.020000~民工=0.020000~亚洲周边各国=0.040000~亚洲=0.013333~各国=0.013333~多元化所有制=0.040000~马克思一元论=0.040000~一元论=0.020000~封闭转向开放=0.040000~开放=0.013333~封闭=0.013333~转向=0.013333~领导班子本身=0.040000~本身=0.020000~领导班子=0.020000~生活糜烂问题=0.040000~生活糜烂=0.020000~出国旅游交钱=0.040000~交钱=0.013333~贸易问题等等=0.040000~等等=0.013333~自身反恐问题=0.040000~自身=0.013333~反恐=0.013333~马克思一元化=0.040000~帝国主义抗战=0.040000~帝国主义=0.020000~抗战=0.020000~人民群众投票=0.040000~投票=0.020000~帝国主义阵营=0.040000~阵营=0.020000~城市祖祖辈辈=0.040000~城市=0.020000~祖祖辈辈=0.020000~军事集团=0.040000~集团=0.020000~军事=0.020000~广东=0.040000~机遇=0.040000~局面=0.040000~法轮功现象=0.040000~法轮功=0.020000~现象=0.020000~人民币战争=0.040000~阿根廷争端=0.040000~争端=0.020000~阿根廷=0.020000~怕中国发展=0.040000~发展=0.013333~四人帮篡夺=0.040000~篡夺=0.020000~四人帮=0.020000~职业经济师=0.040000~经济师=0.020000~职业=0.020000~苏联党执政=0.040000~党执政=0.020000~无产者联合=0.040000~无产者=0.020000~联合=0.020000~学生讲哲学=0.040000~学生=0.013333~哲学=0.013333~步开阔天空=0.040000~天空=0.013333~开阔=0.013333~生产流水线=0.040000~流水线=0.020000~信仰法轮功=0.040000~苏联领导人=0.040000~张思德写下=0.040000~写下=0.020000~张思德塑像=0.040000~塑像=0.020000~40%品牌商=0.040000~40=0.013333~品牌=0.013333~30%中间商=0.040000~中间商=0.020000~30=0.020000~西部=0.040000~培养=0.040000~总理=0.040000~人格感染=0.040000~感染=0.020000~人格=0.020000~社会苦难=0.040000~苦难=0.020000~战争烽烟=0.040000~烽烟=0.020000~双耐克鞋=0.040000~耐克鞋=0.020000~越南战争=0.040000~约束方式=0.040000~约束=0.020000~打铁本身=0.040000~打铁=0.020000~苏联红场=0.040000~红场=0.020000~游说印度=0.040000~印度=0.020000~游说=0.020000~形势变化=0.040000~形势=0.020000~工作职业=0.040000~东欧剧变=0.040000~东欧=0.020000~剧变=0.020000~不足亚洲=0.040000~不足=0.020000~衣厂大门=0.040000~大门=0.013333~政治学习=0.040000~王朝打垮=0.040000~打垮=0.020000~王朝=0.020000~六四风波=0.040000~六四=0.020000~风波=0.020000~结构调整=0.040000~背毛主席=0.040000~浇铸山坡=0.040000~山坡=0.020000~浇铸=0.020000~信念信仰=0.040000~信念=0.020000~利益出发=0.040000~利益=0.020000~出发=0.020000~小的问题=0.040000~小的=0.020000~苦难深渊=0.040000~深渊=0.020000~班子队伍=0.040000~班子=0.020000~出口稀土=0.040000~出口=0.020000~立场方法=0.040000~立场=0.020000~方法=0.020000~灵活运用=0.040000~主义斗争=0.040000~主义=0.020000~委员会=0.040000~调查=0.040000~GDP总量=0.040000~总量=0.020000~gdp=0.020000~保障=0.040000~执行=0.040000~进步=0.040000~来源地=0.040000~胡长清=0.040000~力量=0.040000~讲话=0.030000~长裙=0.030000~实践=0.030000~父母亲=0.030000~做好=0.030000~声炮=0.030000~赴美=0.030000~希望=0.030000~牢骚=0.030000~悬崖=0.030000~制高点=0.030000~干劲=0.030000~初衷=0.030000~是不是=0.020000~拿走=0.020000~多种多样=0.020000~font-family=0.020000~line-height=0.020000~什么样=0.020000~text-align=0.020000~font-size=0.020000~与时俱进=0.020000~增强=0.020000~提到=0.020000~不敢=0.020000~第三=0.020000~看到=0.010000~抓住=0.010000~赫鲁晓夫=0.010000~打碎=0.010000~因人而异=0.010000~孔繁森=0.010000~这么说=0.010000~老三篇=0.010000~多于=0.010000~细致入微=0.010000~曲折=0.010000~挑战=0.010000~不到=0.010000~拿出=0.010000~金桥=0.010000~打出=0.010000~不复存在=0.010000~离去=0.010000~主要矛盾=0.010000~国内=0.010000~化为=0.010000~解体=0.010000~卷入=0.010000~做到=0.010000~justify=0.010000~称为=0.010000~知道=0.010000~回到=0.010000~想到=0.010000~一大二公=0.010000~来讲=0.010000~font-weight=0.010000~text-indent=0.010000~个人崇拜=0.010000~变化多端=0.010000~shorttitle=0.010000~批评=0.010000~bold=0.010000~简而言之=0.010000~这样一来=0.010000~时时刻刻=0.010000~subtitle=0.010000~encoding=0.010000~一百多万=0.010000~一百=0.003333~晓之以理=0.010000~动之以情=0.010000~伤亡=0.010000~离不开=0.010000~现代人=0.010000~做什么=0.010000~遥遥领先=0.010000~UTF-8=0.010000~utf-8=0.010000~环环相扣=0.010000~解决=0.010000~中发=0.010000~起到=0.010000~送到=0.010000~四难=0.010000~退去=0.010000~穿衣=0.010000~极大=0.010000~党内=0.010000~犯下=0.010000~除以=0.010000~五十=0.010000~不肯=0.010000~人本=0.010000~不正=0.010000~不了=0.010000~抓好=0.010000~答应=0.010000~各种各样=0.010000~八九=0.010000~坚持=0.010000~我党=0.010000~五六=0.010000~剩下=0.010000~缩水=0.010000~长期以来=0.010000~e7d8c5=0.010000~新增=0.010000~入侵=0.010000~分化=0.010000~关心=0.010000~起草=0.010000~务实=0.010000~及其=0.010000~拥护=0.010000~重读=0.010000~实现=0.010000~威胁=0.010000~破坏=0.010000~鼓励=0.010000~垮台=0.010000~现代化=0.010000~接手=0.010000~解析=0.010000~争斗=0.010000~表现=0.010000~牵制=0.010000~没落=0.010000~灭亡=0.010000~发表=0.010000~合伙=0.010000~北上=0.010000~关门=0.010000~翻身=0.010000~加速=0.010000~抛弃=0.010000~抵抗=0.010000~挫折=0.010000~正视=0.010000~激荡=0.010000~指引=0.010000~看待=0.010000~尝试=0.010000~爆发=0.010000~占有=0.010000~贯穿=0.010000~估计=0.010000~制约=0.010000~发动=0.010000~小看=0.010000~探索=0.010000~传入=0.010000~掌握=0.010000~突破=0.010000~欢迎=0.010000~反映=0.010000~指导=0.010000~具体=0.010000~关注=0.010000~违背=0.010000~支持=0.010000~增多=0.010000~记得=0.010000~对待=0.010000~允许=0.010000~没完=0.010000~面对面=0.010000~一穷二白=0.010000~满目疮痍=0.010000~进来=0.010000~前面=0.010000~打败=0.010000~偏离=0.010000~3200=0.010000~统领=0.010000~100%=0.010000~100=0.010000~哪些=0.010000~至上=0.010000~争夺=0.010000~巨大=0.010000~完了=0.010000~并存=0.010000~学会=0.010000~千万=0.010000~看见=0.010000~清楚=0.010000~兴起=0.010000~创立=0.010000~吸取=0.010000~说话=0.010000~赶到=0.010000~忘记=0.010000~往来=0.010000~熟悉=0.010000~进取=0.010000~说是=0.010000~出去=0.010000~不对=0.010000~加入=0.010000~确定=0.010000~进去=0.010000~便宜=0.010000~感恩戴德=0.010000~上升=0.010000~属于=0.010000~过犹不及=0.010000~强化=0.010000~严重=0.010000~导致=0.010000~纠结=0.010000~因材施教=0.010000~反对=0.010000~自然规律=0.010000~改变=0.010000~血雨腥风=0.010000~鲜明=0.010000~18.0pt=0.010000~大一统=0.010000~22.0pt=0.010000~20.0pt=0.010000~顺耳=0.010000~0.457=0.010000~制定=0.010000~激烈=0.010000~大相径庭=0.010000~坚定=0.010000~结合=0.010000~1492=0.010000~1978=0.010000~1914=0.010000~构建=0.010000~2005=0.010000~1918=0.010000~150%=0.010000~150=0.010000~取而代之=0.010000~夹杂=0.010000~尊重=0.010000~迎刃而解=0.010000~更新换代=0.010000~20%=0.010000~20=0.010000~97%=0.010000~97=0.010000~103=0.010000~1.0=0.010000~6.6=0.010000~2em=0.010000~15%=0.010000~15=0.010000~35%=0.010000~35=0.010000~合理=0.010000~认为=0.010000~稀有=0.010000~一席之地=0.010000~正确=0.010000~完全=0.010000~厉害=0.010000~高瞻远瞩=0.010000~高空=0.010000~多年=0.010000~了不起=0.010000~内陆=0.010000~外面=0.010000~腐朽=0.010000~适度=0.010000~惊人=0.010000~下功夫=0.010000~过硬=0.010000~后面=0.010000~消极=0.010000~3d2c22=0.010000~据说=0.010000~不错=0.010000~实事求是=0.010000~感慨=0.010000~以外=0.010000~身边=0.010000~沿海=0.010000~壮大=0.010000~家里=0.010000~相同=0.010000~转移=0.010000~准确=0.010000~上来=0.010000~有利=0.010000~容易=0.010000~强大=0.010000~内部=0.010000~主动=0.010000~说明=0.010000~注意=0.010000~强烈=0.010000~深刻=0.010000~完善=0.010000~先进=0.010000~决定=0.010000~需要=0.010000~其中=0.010000~加强=0.010000~进行=0.010000~陈树文=0.600000~经济全球化=0.600000~科技革命=0.600000~思维方式=0.600000~创新意识=0.600000";
		String[] arr1 = str.split("~");
		Map<String,Float> map = new HashMap<String,Float>();
		for(String str1: arr1){
			String[] arr2 = str1.split("=");
			map.put(arr2[0], Float.valueOf(arr2[1]));
		}
		float total = 0f;
		for(Float v :map.values()){
			total += v;
		}
		System.out.println(total);
	}
}
