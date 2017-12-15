package com.mkyong;

public class Triple {
    String HeadEntity;
    String Relation;
    String TailEntity;

    public String getHeadEntity() {
        return HeadEntity;
    }

    public void setHeadEntity(String headEntity) {
        HeadEntity = headEntity;
    }

    public String getRelation() {
        return Relation;
    }

    public void setRelation(String relation) {
        Relation = relation;
    }

    public String getTailEntity() {
        return TailEntity;
    }

    public void setTailEntity(String tailEntity) {
        TailEntity = tailEntity;
    }


    public Triple(String headEntity, String relation, String tailEntity) {
        HeadEntity = headEntity;
        Relation = relation;
        TailEntity = tailEntity;
    }
}
