package com.tomas.kickboxing.model;

public class Fighter {
    private int id;
    private String name;
    private String nickname;
    private String photo;
    private String gender;
    private String birthDate;
    private Integer age;
    private String height;
    private String weight;
    private String reach;
    private String stance;
    private String category;
    private String team;
    private String lastUpdate;

    public Fighter(int id, String name, String nickname, String photo, String gender, String birthDate, Integer age, String height, String weight, String reach, String stance, String category, String team, String lastUpdate) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.photo = photo;
        this.gender = gender;
        this.birthDate = birthDate;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.reach = reach;
        this.stance = stance;
        this.category = category;
        this.team = team;
        this.lastUpdate = lastUpdate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getNickname() { return nickname; }
    public String getPhoto() { return photo; }
    public String getGender() { return gender; }
    public String getBirthDate() { return birthDate; }
    public Integer getAge() { return age; }
    public String getHeight() { return height; }
    public String getWeight() { return weight; }
    public String getReach() { return reach; }
    public String getStance() { return stance; }
    public String getCategory() { return category; }
    public String getTeam() { return team; }
    public String getLastUpdate() { return lastUpdate; }

    @Override
    public String toString() {
        return String.format("%s%s\n  Idade: %s\n  Altura: %s  Peso: %s  Alcance: %s\n  Categoria: %s  Equipe: %s\n  Stance: %s\n  Última atualização: %s\n", 
            name,
            (nickname != null && !nickname.equals("null") ? " (\"" + nickname + "\")" : ""),
            age != null ? age : "-",
            height != null ? height : "-",
            weight != null ? weight : "-",
            reach != null ? reach : "-",
            category != null ? category : "-",
            team != null ? team : "-",
            stance != null ? stance : "-",
            lastUpdate != null ? lastUpdate : "-");
    }
}

