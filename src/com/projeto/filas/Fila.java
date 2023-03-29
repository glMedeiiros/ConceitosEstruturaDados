package com.projeto.filas;

public class Fila<T> {

    private No<T> refNoEntradaFila; // Entrada sempre pelo final na FILA

    public Fila() {
        refNoEntradaFila = null;
    }

    public void enqueue(T obj){ //Refatoracao do No embutido direto na classe Fila
        No<T> novoNo = new No(obj);
        novoNo.setRefNo(refNoEntradaFila); //Set referecia do novoNo para o primeiro valor(Object).
        refNoEntradaFila = novoNo;
    }

    public T first() { //Retorna o primeiro da fila / Refatoracao em retornar No para retornar object
        if(!this.isEmpty()){
            No<T> primeiroNo = refNoEntradaFila; //Pega referencia do ultimo da fila;

            while(true){
                if(primeiroNo.getRefNo() != null){
                    primeiroNo = primeiroNo.getRefNo(); //Enquanto TRUE vai passando de No em No gracas a referencia entre os NOs ate chegar no primeiro.
                }else{
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public T dequeue() {//Retirar o primeiro valor da FILA / Refatoracao em retornar No para retornar object
        if(!this.isEmpty()){
            No<T> primeiroNo = refNoEntradaFila;
            No<T> noAuxiliar = refNoEntradaFila;

            while(true){
                if(primeiroNo.getRefNo() != null){
                    noAuxiliar = primeiroNo; //Salva o valor anterior ao de baixo(primeiroNo)
                    primeiroNo = primeiroNo.getRefNo(); //Enquanto TRUE vai passando de No em No gracas a referencia entre os NOs ate chegar no primeiro.
                }else{
                    noAuxiliar.setRefNo(null);//Set segundo No com referencia para NULL(Passa a ser o primeiro da fila)
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoEntradaFila == null ? true : false;
    }

    @Override
    public String toString() {
       String stringRetorno = "";
       No<T> noAuxiliar = refNoEntradaFila;

       if(refNoEntradaFila != null) {
           while (true){
               stringRetorno += "[No{objeto= " + noAuxiliar.getObject() + "}]--->";

               if(noAuxiliar.getRefNo() != null){
                   noAuxiliar = noAuxiliar.getRefNo();
               }else{
                   stringRetorno += "null";
                   break;
               }
           }
       }else{
           stringRetorno = "null";
       }
       return stringRetorno;
    }
}
