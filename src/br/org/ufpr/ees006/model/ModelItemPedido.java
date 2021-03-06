/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ufpr.ees006.model;

import br.org.ufpr.ees006.foundation.ItemDoPedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thiago Luis Garcia
 */
public class ModelItemPedido extends AbstractTableModel{
  
  private final String[] colunas;
  private List<ItemDoPedido> lista = new ArrayList();

  public ModelItemPedido(List<ItemDoPedido> lista) {
    this.colunas = new String[]{"Produto", "Quantidade"};
    this.lista = lista;
  }
  
  public ModelItemPedido() {
    this.colunas = new String[]{"Produto", "Quantidade"};
  }
  
  @Override
  public boolean isCellEditable(int row, int col) {
    return false;
  }
  
  @Override
  public void setValueAt(Object item, int rowIndex, int columnIndex) {
    this.lista.set(rowIndex, (ItemDoPedido) item);
    this.fireTableDataChanged(); 
  }
  
  @Override
  public int getRowCount() {
    return this.lista.size();
  }

  @Override
  public int getColumnCount() {
    return this.colunas.length; 
  }
  
  @Override
  public String getColumnName(int index) {
    return this.colunas[index];
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    ItemDoPedido itemDoPedido = lista.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return itemDoPedido.getProduto().getDescricao();
      case 1:
        return itemDoPedido.getQtdade();
      default:
        return null;
    } 
  }
  
  public void setValue(ItemDoPedido item) {
    
    if ( this.lista.add(item) ) {
      this.fireTableDataChanged();
    }
  }
  
  public void delete(int linha) {

    if ( getRowCount() > 1 ) {
      this.lista.remove(linha);
    } else {
      this.lista.clear();
    }
    this.fireTableDataChanged();
    
  }
  
  public void setListItens(List<ItemDoPedido> itemDoPedido) {
    this.lista = itemDoPedido;
    this.fireTableDataChanged();
  }
  
  public ItemDoPedido getItem(int linha) {
    return lista.get(linha);
  }
  
  public List<ItemDoPedido> getItens() {
    return lista;
  }
  
}
