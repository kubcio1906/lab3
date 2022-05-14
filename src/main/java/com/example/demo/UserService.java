package com.example.demo;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.swing.*;
import java.io.*;
import java.util.*;


@Service
public class UserService {
    private static HashMap<Integer,UserEntity> hashMap = new HashMap<>();
    int id=1;
    public void create(UserEntity user){

        user.setUserId(id);
        hashMap.put(user.getUserId(), user);
        id++;


}
public UserEntity getOne(int id){

        return hashMap.get(id);

}
public void update(int id,UserEntity userEntity){

        userEntity.setUserId(id);
        hashMap.replace(userEntity.getUserId(), userEntity);


}
public String delete (int id){

        hashMap.remove(id);
        return "{\"result\": true}";
}

public HashMap<Integer,UserEntity> showAll(){

        return hashMap;
}
public InfoEntity show(int pageNumber,int pageSize){
        double pagesCount;
        pagesCount = Math.ceil(hashMap.size()/pageSize);
        double totalCount;
        totalCount = hashMap.size();
        int low =(pageNumber-1)*pageSize;
        double high = pageNumber*pageSize>totalCount?totalCount : pageNumber*pageSize;

        List<UserEntity> userList = new ArrayList<>(hashMap.values());
        List<UserEntity> doneList = userList.subList(low,(int)high);

        InfoEntity infoEntity = new InfoEntity(pageNumber,pagesCount,pageSize,totalCount,userList);


        return  infoEntity;
}
    @PostConstruct
    private void onCreate() throws FileNotFoundException {
        File file = new File(
                "test.csv");
        BufferedReader br
                = new BufferedReader(new FileReader(file));
    }

    @PreDestroy
    private void onDestroy() throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.csv"));
        out.writeObject(hashMap);
        out.close();


    }



}
