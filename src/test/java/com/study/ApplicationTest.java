package com.study;

import com.study.domain.BigCategory;
import com.study.domain.SmallCategory;
import com.study.domain.Subject;
import com.study.domain.User;
import com.study.repository.BigCategoryRepository;
import com.study.repository.SmallCategoryRepository;
import com.study.repository.SubjectRepository;
import com.study.repository.UserRepository;
import com.study.service.IBigCategoryService;
import com.study.service.IUerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private IUerService uerService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BigCategoryRepository bigCategoryRepository;

    @Autowired
    private SmallCategoryRepository smallCategoryRepository;

    @Autowired
    private IBigCategoryService bigCategoryService;

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    public void bigCategory3() {
        BigCategory bigCategory = new BigCategory();
        bigCategory.setBigCategoryName("測試");
        bigCategory.setBigCategoryId(3);
         bigCategoryRepository.save(bigCategory);
        bigCategory.setBigCategoryName("haha");
        bigCategoryRepository.save(bigCategory);
    }
    @Test
    public void subject2(){
        List<Subject> subjects = new LinkedList<>();
//        (8, 2, '活泼性格'),
        subjects.add(new Subject("在日常生活中，比较符合哪个选项？",5,
                "非常活泼、好动、爱说话","沉默寡言","喜欢聆听","喜欢安静",0,8,2));
        subjects.add(new Subject("在人际交往中，比较符合哪个选项？",5,
                "善于社交","意志坚定","不善交际","温良平和",0,8,2));
        subjects.add(new Subject("在日常游戏中，喜欢扮演哪个角色？",5,
                "发起者","领导者","调解者","聆听者",0,8,2));
        subjects.add(new Subject("在思维方式中，比较符合哪个选项？",5,
                "跳跃性","攻击性","规范性","顺从性",0,8,2));
        subjects.add(new Subject("在处理事务中，比较符合哪个选项？",5,
                "主动","逆反","挑剔","胆小",0,8,2));
        subjects.add(new Subject("在生活自我管理中，比较符合哪个选项？",5,
                "生机勃勃吧","贯彻始终","井井有条","愿意听从",0,8,2));
//        (9, 2, '青少年日常行为'),
        subjects.add(new Subject("在日常生活中，哪项认为是正确的？",5,
                "仪表端庄，和谐文雅","穿戴不整洁","不喜欢运动","不刷牙",0,9,2));
        subjects.add(new Subject("说话时，应该注意什么？",5,
                "语言肮脏","语言文明","骂人","说脏话",1,9,2));
        subjects.add(new Subject("别人与你交谈，应该怎么做？",5,
                "专心听别人讲","随便插嘴","不喜欢听就不听","随便听听",0,9,9));
        subjects.add(new Subject("我想主持主题中队会，可是队员推荐李杨作主持人，让我帮助中队委筹备队会，我应该怎么做？",5,
                "很生气，请病假不参加活动","完全服从队的决议","不情愿服从队的决议，随便筹备队会","拒绝服从",1,9,9));
        subjects.add(new Subject("有客人到校或者到班级里听课，我应该怎么做？",5,
                "与平常一样，就当作没有人过来","主动问好","好奇的问同学去看","不让他们进来",1,9,2));
        subjects.add(new Subject("迟到或者有事情晚进入教师，应该怎么做？",5,
                "报告老师，同意后进入","不进入","偷偷进入","随便进入",0,9,2));
//        (10, 2, '语文测试'),
        subjects.add(new Subject("当你新接触到一个外语单词，你能在第一时间记住它的拼写吗？",5,
                "总是","偶尔","几次","记不住",0,10,2));
        subjects.add(new Subject("在你的朋友中，又很多讲各自家乡话的人，在与人交往一段时间后，你发现你也能和他们以同样的方言交流吗？",5,
                "总是","偶尔","几次","不能",0,10,2));
        subjects.add(new Subject("当你对外语有了一定的了解后，你愿意看原版电影，还是看中文翻译？",5,
                "看原版","看中文","偶尔看原版","实在没有中文，才看原版",0,10,2));
        subjects.add(new Subject("当你第一次听到某外国语种时，对哪些稀奇古怪的读音，又什么感受？",5,
                "非常有兴趣","没感觉","不自在","非常不自在",0,10,2));
        subjects.add(new Subject("你会唱一首外国歌曲吗或者背诵外语散文吗？",5,
                "会","不会外语","只背诵中文","没尝试过",0,10,2));
        subjects.add(new Subject("你可以马上说出不同种类的词语各项用法吗？",5,
                "可以马上","偶尔可以","不会","根本说不出来",0,10,2));
//        (11, 2, '专研学科测试'),
        subjects.add(new Subject("硬科幻、悬疑烧脑片能看懂？",5,
                "可以看得懂","偶尔看得懂","稍微看得懂","看不懂",0,11,2));
        subjects.add(new Subject("三体原著能2-3口气看完的基本没问题？",5,
                "可以","不行","需要很久","完全不行",0,11,2));
        subjects.add(new Subject("这次疫情中有没有感觉到极度不适？",5,
                "没有感觉","偶尔感觉","一点点不适","非常不舒服",0,11,2));
        subjects.add(new Subject("这次疫情中，在无人监管的状态下，有没有每天完成一些学习任务？",5,
                "每天都在学习","不学习","偶尔学习","睡觉",0,11,2));
        subjects.add(new Subject("写文档时，文档格式需要调整吗？",5,
                "不用调整","格式非常错乱，需要来来回回调整","格式前后不一致，需要调整","偶尔调整",0,11,2));
        subjects.add(new Subject("学习新鲜事务，例如学做饭，一学就会？",5,
                "一学就会","要很久才可以学会","永远学不会","偶尔学会",0,11,2));
        //  (12, 2, '视觉型学习风格'),
        subjects.add(new Subject("日常爱好比较符合哪个选项？",5,
                "喜欢画画、拼图，动手能力强","喜欢听故事","好动，不愿守规矩","喜欢静静得呆着",0,12,2));
        subjects.add(new Subject("日常说话比较符合哪个选项？",5,
                "不爱说话","偶尔说话","爱说、爱讲","模仿说话",1,12,2));
        subjects.add(new Subject("说话思考速度？",5,
                "快","慢","中等","比较慢",0,12,2));
        subjects.add(new Subject("迷路时，应该怎么做？",5,
                "看地图","问路","相信直觉","等爸爸妈妈",1,12,2));
        subjects.add(new Subject("业务时间，喜欢做什么？",5,
                "运动","看电影","看书","听音乐",0,12,2));
        subjects.add(new Subject("上课表现是怎样的？",5,
                "目不转睛看黑板","心不在焉","动来动去","趴在桌上",2,12,2));
//        (13, 2, '音乐天赋'),
        subjects.add(new Subject("唱歌音阶怎么样？",5,
                "很准","不准","偶尔准","不喜欢唱歌",0,13,2));
        subjects.add(new Subject("背诗和韵律的句子怎么样？",5,
                "很出色","不出色","偶尔出色","不背诗和韵律的句子",0,13,2));
        subjects.add(new Subject("辨别乐器的声音能力怎么样？",5,
                "很准","不准","偶尔准","不辨别",0,13,2));
        subjects.add(new Subject("喜欢跟着儿歌一起唱歌？",5,
                "喜欢","不喜欢","偶尔唱","从来不唱",0,13,2));
        subjects.add(new Subject("播放音乐，会跟着音乐一起做动作？",5,
                "会，并且做的很协调","会，但是不协调","偶尔做","不做",0,13,2));
        subjects.add(new Subject("可以精彩的讲故事？",5,
                "可以，声情并茂","会讲，但是讲的不好","偶尔讲","不讲",0,13,2));
//        (14, 2, '体育天赋');
        subjects.add(new Subject("你是不是觉得会打篮球的人很帅气？",5,
                "是的","不是","偶尔","看情况",0,14,2));
        subjects.add(new Subject("你是不是觉得女生会打篮球是一件很酷的事情？",5,
                "是的","不是","偶尔","看情况",0,14,2));
        subjects.add(new Subject("篮球对你来说是不是一项有趣的运动？",5,
                "是的","不是","偶尔","看情况",0,14,2));
        subjects.add(new Subject("游戏和篮球你更喜欢哪个？",5,
                "篮球","游戏","都不喜欢","看情况",0,14,2));
        subjects.add(new Subject("你是否关注NBA？",5,
                "是的","不是","偶尔","看情况",0,14,2));
        subjects.add(new Subject("你腿脚很协调？",5,
                "是的","不是","偶尔","看情况",0,14,2));
        subjectRepository.saveAll(subjects);
    }
    @Test
    public void subject1(){
        List<Subject> subjects = new LinkedList<>();
        //        (1, 1, '活泼性格'),
        subjects.add(new Subject("在日常生活中，比较符合哪个选项？",5,
                "喜好娱乐","善于说服","坚持不屑","适应力强",0,1,1));
        subjects.add(new Subject("在人际交往中，比较符合哪个选项？",5,
                "善于社交","意志坚定","不善交际","温良平和",0,1,1));
        subjects.add(new Subject("在日常游戏中，喜欢扮演哪个角色？",5,
                "发起者","领导者","调解者","聆听者",0,1,1));
        subjects.add(new Subject("在思维方式中，比较符合哪个选项？",5,
                "跳跃性","攻击性","规范性","顺从性",0,1,1));
        subjects.add(new Subject("在处理事务中，比较符合哪个选项？",5,
                "主动","逆反","挑剔","胆小",0,1,1));
        subjects.add(new Subject("在生活自我管理中，比较符合哪个选项？",5,
                "生机勃勃吧","贯彻始终","井井有条","愿意听从",0,1,1));
//        (2, 1, '儿童日常行为'),
        subjects.add(new Subject("如果走在马路上忽然想吐痰，又找不到垃圾桶，应该怎么办？",5,
                "吐在路边","含在嘴里","咽下去","吐在纸巾里",3,2,1));
        subjects.add(new Subject("下面哪个做法不正确？",5,
                "节约用水","节约用电","在桌椅板上乱画乱刻","随手关灯",2,2,1));
        subjects.add(new Subject("迟到或者有事情晚进入教师，应该怎么做？",5,
                "报告老师，同意后进入","不进入","偷偷进入","随便进入",0,2,1));
        subjects.add(new Subject("别人与你交谈，应该怎么做？",5,
                "专心听别人讲","随便插嘴","不喜欢听就不听","随便听听",0,2,1));
        subjects.add(new Subject("我想主持主题中队会，可是队员推荐李杨作主持人，让我帮助中队委筹备队会，我应该怎么做？",5,
                "很生气，请病假不参加活动","完全服从队的决议","不情愿服从队的决议，随便筹备队会","拒绝服从",1,2,1));
        subjects.add(new Subject("有客人到校或者到班级里听课，我应该怎么做？",5,
                "与平常一样，就当作没有人过来","主动问好","好奇的问同学去看","不让他们进来",1,2,1));
//        (3, 1, '儿童智力'),
        subjects.add(new Subject("农户有17只羊，9只都病死了，还剩几只羊？",5,
                "8","9","7","6",0,3,1));
        subjects.add(new Subject("谁从来不看医生？",5,
                "聋子","瞎子","瘸子","正常人",1,3,1));
        subjects.add(new Subject("鱼缸里有9条鱼，走近一看死了2条，这时鱼缸里还有几条鱼？",5,
                "9","8","7","6",0,3,1));
        subjects.add(new Subject("父子俩对手下棋，每人都下了5盘，他们一共下了几盘棋？",5,
                "5","10","20","6",0,3,1));
        subjects.add(new Subject("一面五星红旗上有两种颜色，10面五星红旗拱有多少中颜色？",5,
                "10","20","6","2",3,3,1));
        subjects.add(new Subject("一个人唱完学雷锋用了2分钟，3个人唱完这首歌，最少用积几分钟？",5,
                "1","2","4","6",1,3,1));
//        (4, 1, '心理健康'),
        subjects.add(new Subject("爱发脾气，控制能力差？",5,
                "从不","偶尔","常常","总是",0,4,1));
        subjects.add(new Subject("一到考试就焦虑、压力大？",5,
                "从不","偶尔","常常","总是",0,4,1));
        subjects.add(new Subject("厌学、逃学不上课，爱开小差？",5,
                "从不","偶尔","常常","总是",0,4,1));
        subjects.add(new Subject("人际交往差、不合群，不喜欢交朋友？",5,
                "从不","偶尔","常常","总是",0,4,1));
        subjects.add(new Subject("没有自信、胆小、自卑？",5,
                "从不","偶尔","常常","总是",0,4,1));
        subjects.add(new Subject("做事情，坚持不了多久，没有集中力？",5,
                "从不","偶尔","常常","总是",0,4,1));
//        (5, 1, '动觉型学习风格'),
        subjects.add(new Subject("日常爱好比较符合哪个选项？",5,
                "喜欢画画、拼图，动手能力强","喜欢听故事","好动，不愿守规矩","喜欢静静得呆着",0,5,1));
        subjects.add(new Subject("日常说话比较符合哪个选项？",5,
                "不爱说话","偶尔说话","爱说、爱讲","模仿说话",1,5,1));
        subjects.add(new Subject("说话思考速度？",5,
                "快","慢","中等","比较慢",0,5,1));
        subjects.add(new Subject("迷路时，应该怎么做？",5,
                "看地图","问路","相信直觉","等爸爸妈妈",1,5,1));
        subjects.add(new Subject("业务时间，喜欢做什么？",5,
                "运动","看电影","看书","听音乐",0,5,1));
        subjects.add(new Subject("上课表现是怎样的？",5,
                "目不转睛看黑板","心不在焉","动来动去","趴在桌上",2,5,1));
//        (6, 1, '音乐天赋'),
        subjects.add(new Subject("唱歌音阶怎么样？",5,
                "很准","不准","偶尔准","不喜欢唱歌",0,6,1));
        subjects.add(new Subject("背诗和韵律的句子怎么样？",5,
                "很出色","不出色","偶尔出色","不背诗和韵律的句子",0,6,1));
        subjects.add(new Subject("辨别乐器的声音能力怎么样？",5,
                "很准","不准","偶尔准","不辨别",0,6,1));
        subjects.add(new Subject("喜欢跟着儿歌一起唱歌？",5,
                "喜欢","不喜欢","偶尔唱","从来不唱",0,6,1));
        subjects.add(new Subject("播放音乐，会跟着音乐一起做动作？",5,
                "会，并且做的很协调","会，但是不协调","偶尔做","不做",0,6,1));
        subjects.add(new Subject("可以精彩的讲故事？",5,
                "可以，声情并茂","会讲，但是讲的不好","偶尔讲","不讲",0,6,1));
//        (7, 1, '体育天赋'),
        subjects.add(new Subject("日常是否经常跑来跑去？",5,
                "经常","偶尔","不经常","不跑步",0,7,1));
        subjects.add(new Subject("日常是否经常跳来跳去？",5,
                "经常","偶尔","不经常","不跳",0,7,1));
        subjects.add(new Subject("日常是否可以跑很久？",5,
                "非常久","就只能跑一会","一般","不跑步",0,7,1));
        subjects.add(new Subject("柔韧性好不好？",5,
                "非常好","一般","不好","不知道",0,7,1));
        subjects.add(new Subject("每天运动时间长不长？",5,
                "经常长","不长","一般","偶尔长",0,7,1));
        subjects.add(new Subject("喜欢看体育类的电视吗？",5,
                "非常喜欢","偶尔","一般","不喜欢",0,7,1));
        subjects.add(new Subject("喜欢户外活动吗？",5,
                "非常喜欢","偶尔喜欢","不喜欢","喜欢在家里带着",0,7,1));
        subjectRepository.saveAll(subjects);
    }



    @Test
    public void bigCategory1(){
//        bigCategoryRepository.deleteAll();
//        smallCategoryRepository.deleteAll();
//        BigCategory bigCategory = new BigCategory();
//        bigCategory.setBigCategoryName("儿童测试");
//        bigCategory = bigCategoryRepository.saveAndFlush(bigCategory);
//
//        List<SmallCategory> smallCategoryList = new ArrayList<>();
//        bigCategory.setSmallCategories(smallCategoryList);
//        //儿童：性格特质，日常行为测试，智力潜能，学习风格，艺术天赋，体育天赋，能力特长
//        smallCategoryList.add(new SmallCategory("活泼性格",bigCategory.getBigCategoryId()));
//        smallCategoryList.add(new SmallCategory("儿童日常行为",bigCategory.getBigCategoryId()));
//        smallCategoryList.add(new SmallCategory("儿童智力",bigCategory.getBigCategoryId()));
//        smallCategoryList.add(new SmallCategory("心理健康",bigCategory.getBigCategoryId()));
//        smallCategoryList.add(new SmallCategory("动觉型学习风格",bigCategory.getBigCategoryId()));
//        smallCategoryList.add(new SmallCategory("音乐天赋",bigCategory.getBigCategoryId()));
//        smallCategoryList.add(new SmallCategory("体育天赋",bigCategory.getBigCategoryId()));
//        smallCategoryRepository.saveAll(smallCategoryList);

        //青少年：性格特质，日常行为测试，学科选择测试，高考志愿填报（性格与专业），学习风格，艺术天赋，体育天赋，能力特长

    }
    @Test
    public void bigCategory2(){
//        BigCategory bigCategory = new BigCategory();
//        bigCategory.setBigCategoryName("青少年测试");
//        bigCategory = bigCategoryRepository.saveAndFlush(bigCategory);
//
//        List<SmallCategory> smallCategoryList = new ArrayList<>();
//        bigCategory.setSmallCategories(smallCategoryList);
//        //儿童：性格特质，日常行为测试，智力潜能，学习风格，艺术天赋，体育天赋，能力特长
//        smallCategoryList.add(new SmallCategory("活泼性格",bigCategory.getBigCategoryId()));
//        smallCategoryList.add(new SmallCategory("青少年日常行为",bigCategory.getBigCategoryId()));
//        smallCategoryList.add(new SmallCategory("语文测试",bigCategory.getBigCategoryId()));
//        smallCategoryList.add(new SmallCategory("专研学科测试",bigCategory.getBigCategoryId()));
//        smallCategoryList.add(new SmallCategory("视觉型学习风格",bigCategory.getBigCategoryId()));
//        smallCategoryList.add(new SmallCategory("音乐天赋",bigCategory.getBigCategoryId()));
//        smallCategoryList.add(new SmallCategory("体育天赋",bigCategory.getBigCategoryId()));
//        smallCategoryRepository.saveAll(smallCategoryList);


    }


}
