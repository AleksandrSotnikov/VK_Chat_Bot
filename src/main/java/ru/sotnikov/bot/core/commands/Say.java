package ru.sotnikov.bot.core.commands;

public class Say {
    public String sayAll(){
        return "позвал всех - @all";
    }
    public String sayOnline(){
        return "позвал людей находящихся онлайн - @online" + " \uD83D\uDE01";
    }
    public String sayAttack() {return "уебал ";}
    public String sayAttack(String name)
    {
        if(name.startsWith("[")&&name.endsWith("]")&&name.contains("@")&&name.contains("id")&&!name.contains(" "))
            return "уебал" + name;
        else return "Цель не найдена";
    }
    public String sayBite(){
        return "укусил ";
    }
    public String sayBite(String name){
        if(name.startsWith("[")&&name.endsWith("]")&&name.contains("@")&&name.contains("id")&&!name.contains(" "))
            return "искусал всего" + name;
        else return "Цель не найдена";
    }
    public String sayTrax(String name)
    {
        if(name.startsWith("[")&&name.endsWith("]")&&name.contains("@")&&name.contains("id")&&!name.contains(" "))
            return "Надругался" + name;
        else return "Цель не найдена";
    }
    public String sayHome(){
        return " я тут, чего звал?";
    }
}
