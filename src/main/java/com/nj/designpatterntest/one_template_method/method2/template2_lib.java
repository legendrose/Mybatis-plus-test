package com.nj.designpatterntest.one_template_method.method2;


public abstract class template2_lib {

    public Boolean step1(){
        return true;
    }
    public Boolean step3(){
        return true;
    }
    public void step5(){
        System.out.println("步骤五");
    }
    protected  abstract void step2();
    protected abstract void step4();

    public void run(){
        if(this.step1()) {
            this.step2();
        }
        if (this.step3()){
            this.step4();
        }
        this.step5();
    }
}
