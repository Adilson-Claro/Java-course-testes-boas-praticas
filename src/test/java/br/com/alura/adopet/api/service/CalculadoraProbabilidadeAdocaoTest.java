package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraProbabilidadeAdocaoTest {

    @Test
    @DisplayName("Deve retornar probabilidade ALTA para gastos com idade baixa e peso baixo")
    void probabilidadeAltaCenario01(){
        //idade 4 anos e 4 kg - ALTA

        //ARRANGE
        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                "Abrigo feliz,",
                "9499999999",
                "abrigofeliz@gmail.com"));
        Pet pet = new Pet(new CadastroPetDto(TipoPet.GATO,
                "Miau",
                "Siames",
                4,
                "Cinza",
                4.0f), abrigo);

        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();

        //ACTION
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        //ASSERT
        Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
    }
    @Test
    @DisplayName("Deve retornar porbabilidade MEDIA para gatos com idade alta e peso baixo")
    void probabilidadeMediaCenario02() {
        //idade 15 anos e 4kg - MEDIA

        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                "Abrigo feliz",
                "94999999999",
                "abrigofeliz@email.com.br"
        ));
        Pet pet = new Pet(new CadastroPetDto(
                TipoPet.GATO,
                "Miau",
                "Siames",
                15,
                "Cinza",
                4.0f
        ), abrigo);

        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
    }

}