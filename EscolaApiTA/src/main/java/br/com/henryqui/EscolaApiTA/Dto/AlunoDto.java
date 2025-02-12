package br.com.henryqui.EscolaApiTA.Dto;

public class AlunoDto {

    private Integer id;
    private String nome;
    private Integer cursoid;

    public AlunoDto(Integer id, String nome, Integer cursoid) {
        this.id = id;
        this.nome = nome;
        this.cursoid = cursoid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCursoid() {
        return cursoid;
    }

    public void setCursoid(Integer cursoid) {
        this.cursoid = cursoid;
    }
}
