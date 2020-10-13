package service;


import org.springframework.stereotype.Service;

@Service
public class convertServiceImpl implements convertService{

    @Override
    public int convert(int money) {
        return money * 23000;
    }
}
