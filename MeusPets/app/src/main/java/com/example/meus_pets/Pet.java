package com.example.meus_pets;

public class Pet {
    private int idPet;
    private String nomePet;
    private String tipoAnimal;
    private String raca;
    private String cor;
    private int anoNascimento;
    private int mesNascimento;
    private int diaNascimento;

    public Pet(int idPet, String nomePet, String tipoAnimal, String raca, String cor, int anoNascimento, int mesNascimento, int diaNascimento) {
        this.idPet = idPet;
        this.nomePet = nomePet;
        this.tipoAnimal = tipoAnimal;
        this.raca = raca;
        this.cor = cor;
        this.anoNascimento = anoNascimento;
        this.mesNascimento = mesNascimento;
        this.diaNascimento = diaNascimento;
    }

    public Pet(String nomePet, String tipoAnimal, String raca, String cor, int anoNascimento, int mesNascimento, int diaNascimento) {
        this.nomePet = nomePet;
        this.tipoAnimal = tipoAnimal;
        this.raca = raca;
        this.cor = cor;
        this.anoNascimento = anoNascimento;
        this.mesNascimento = mesNascimento;
        this.diaNascimento = diaNascimento;
    }



    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getMesNascimento() {
        return mesNascimento;
    }

    public void setMesNascimento(int mesNascimento) {
        this.mesNascimento = mesNascimento;
    }

    public int getDiaNascimento() {
        return diaNascimento;
    }

    public void setDiaNascimento(int diaNascimento) {
        this.diaNascimento = diaNascimento;
    }
}
