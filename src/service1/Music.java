package service;

import domain.Music;

public class Music_function {


//获取音乐
    public static Music getMusic(int music_id){

        Music music;
        music=dao.getMusicFromDB(music_id);
        return music;
    }
    //获取用户
    public static User getUser(int user_id){
      User user;
       user=dao.getUserFromDB(user_id);
        return user;
    }

    //获取小组
    public static Group getGroup(int group_id) {
        Group group;
        group=dao.getGroupFromDB(group_id);
        return group;
    }

    //获取项目
    public static Project getProject(int project_id){
        Project project;
        project=dao.getProjectFromDB(project_id);
        return project;
    }

    //获取推荐小组getRecommandGroup()
    定义
    public static Group[] getRecommandGroup(int num，Group[])

    {
        Group[] group = new Group [num];
     for(int i=0;i<num;i++){
    //分别获取推荐小组的图像，名字


     }

        return group;
    }


    //获取音乐的某条评论getMusicComment()

    public static Comment getMusicComment(int music_id,int num,int type) {
        //int music_id 音乐ID int num 第几条评论 int type 排序类型，0 表示按热度（点赞数）排序，1 表示按时间排序

        Music music;
        music=getMusic(music_id);
Comment comment=music.getMusic_comments(int num,int type);


        return comment;
    }
    //获取相似音乐getFamiliarMusic()

    public static Music[] getFamiliarMusic(int music_id,int num) {
        Music music;
        music=getMusic(music_id);
       // int music_id 音乐ID int num 获取相似音乐的数量
        Music[] musics = new Music [num];
        musics=music.getLikes(music_id,num);
           return musics;
    }


    //点赞
    public static void Great(int music_id){
       //获得点赞数最高的三个评论对象


        //返回对象




    }


//说明参与创作这首歌的人
    //public static void People(Music)







}



