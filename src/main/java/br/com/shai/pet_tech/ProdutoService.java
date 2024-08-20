package br.com.shai.pet_tech;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Collection<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(UUID id){
        return produtoRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Produto não encontrado"));
    }

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto update(UUID id, Produto produto){
        try{
            Produto buscaProduto = produtoRepository.getOne(id);
            buscaProduto.setNome(produto.getNome());
            buscaProduto.setDescricao(produto.getDescricao());
            buscaProduto.setPreco(produto.getPreco());
            buscaProduto.setUrlDaImagem(produto.getUrlDaImagem());
            buscaProduto = produtoRepository.save(buscaProduto);
            return buscaProduto;
        } catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Produto não encontrado!");
        }
    }

    public void delete(UUID id){
        produtoRepository.deleteById(id);
    }
}
