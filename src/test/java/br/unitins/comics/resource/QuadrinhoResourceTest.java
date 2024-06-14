package br.unitins.comics.resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.unitins.comics.dto.QuadrinhoDTO;
import br.unitins.comics.dto.QuadrinhoResponseDTO;
import br.unitins.comics.model.ArtistaCapa;
import br.unitins.comics.model.Categoria;
import br.unitins.comics.model.Escritor;
import br.unitins.comics.model.Genero;
import br.unitins.comics.model.Origem;
import br.unitins.comics.model.Quadrinho;
import br.unitins.comics.repository.ArtistaCapaRepository;
import br.unitins.comics.repository.CategoriaRepository;
import br.unitins.comics.repository.EscritorRepository;
import br.unitins.comics.repository.GeneroRepository;
import br.unitins.comics.repository.OrigemRepository;
import br.unitins.comics.repository.QuadrinhoRepository;
import br.unitins.comics.service.QuadrinhoServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class QuadrinhoResourceTest {

    @Mock
    private QuadrinhoRepository quadrinhoRepository;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Mock
    private EscritorRepository escritorRepository;

    @Mock
    private ArtistaCapaRepository artistaCapaRepository;

    @Mock
    private GeneroRepository generoRepository;

    @Mock
    private OrigemRepository origemRepository;

    @InjectMocks
    private QuadrinhoServiceImpl quadrinhoService;

    private QuadrinhoDTO quadrinhoDTO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        // Configura o DTO para ser usado nos testes
        quadrinhoDTO = new QuadrinhoDTO(
            "Nome do Quadrinho",
            LocalDate.now(),
            "1ª Edição",
            19.99,
            120,
            1L,
            1L,
            1L,
            1,
            1L,
            1L,
            10
        );
    }

    @Test
    public void testCreateQuadrinho() {
        Categoria categoria = new Categoria();
        Escritor escritor = new Escritor();
        ArtistaCapa artistaCapa = new ArtistaCapa();
        Genero genero = new Genero();
        Origem origem = new Origem();

        when(categoriaRepository.findById(1L)).thenReturn(categoria);
        when(escritorRepository.findById(1L)).thenReturn(escritor);
        when(artistaCapaRepository.findById(1L)).thenReturn(artistaCapa);
        when(generoRepository.findById(1L)).thenReturn(genero);
        when(origemRepository.findById(1L)).thenReturn(origem);

        QuadrinhoResponseDTO responseDTO = quadrinhoService.create(quadrinhoDTO);

        assertNotNull(responseDTO);
        assertEquals("Nome do Quadrinho", responseDTO.nome());
        verify(quadrinhoRepository, times(1)).persist(any(Quadrinho.class));
    }

    @Test
    public void testUpdateQuadrinho() {
        Quadrinho quadrinho = new Quadrinho();
        quadrinho.setId(1L);

        when(quadrinhoRepository.findById(1L)).thenReturn(quadrinho);

        Categoria categoria = new Categoria();
        Escritor escritor = new Escritor();
        ArtistaCapa artistaCapa = new ArtistaCapa();
        Genero genero = new Genero();
        Origem origem = new Origem();

        when(categoriaRepository.findById(1L)).thenReturn(categoria);
        when(escritorRepository.findById(1L)).thenReturn(escritor);
        when(artistaCapaRepository.findById(1L)).thenReturn(artistaCapa);
        when(generoRepository.findById(1L)).thenReturn(genero);
        when(origemRepository.findById(1L)).thenReturn(origem);

        quadrinhoService.update(1L, quadrinhoDTO);

        assertEquals("Nome do Quadrinho", quadrinho.getNome());
        verify(quadrinhoRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteQuadrinho() {
        quadrinhoService.delete(1L);

        verify(quadrinhoRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testFindById() {
        Quadrinho quadrinho = new Quadrinho();
        quadrinho.setId(1L);

        when(quadrinhoRepository.findById(1L)).thenReturn(quadrinho);

        QuadrinhoResponseDTO responseDTO = quadrinhoService.findById(1L);

        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.id());
        verify(quadrinhoRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        Quadrinho quadrinho1 = new Quadrinho();
        quadrinho1.setId(1L);
        Quadrinho quadrinho2 = new Quadrinho();
        quadrinho2.setId(2L);

        when(quadrinhoRepository.listAll()).thenReturn(Arrays.asList(quadrinho1, quadrinho2));

        List<QuadrinhoResponseDTO> responseDTOList = quadrinhoService.findAll();

        assertEquals(2, responseDTOList.size());
        verify(quadrinhoRepository, times(1)).listAll();
    }

    @Test
    public void testFindByNome() {
        Quadrinho quadrinho = new Quadrinho();
        quadrinho.setNome("Nome do Quadrinho");

        when(quadrinhoRepository.findByNome("Nome")).thenReturn(Arrays.asList(quadrinho));

        List<QuadrinhoResponseDTO> responseDTOList = quadrinhoService.findByNome("Nome");

        assertEquals(1, responseDTOList.size());
        assertEquals("Nome do Quadrinho", responseDTOList.get(0).nome());
        verify(quadrinhoRepository, times(1)).findByNome("Nome");
    }
}