package com.projeto.filas;

public class Fila {

    private No refNoEntradaFila; // Entrada sempre pelo final na FILA

    public Fila() {
        refNoEntradaFila = null;
    }

    public void enqueue(Object obj){ //Refatoracao do No embutido direto na classe Fila
        No novoNo = new No(obj);
        novoNo.setRefNo(refNoEntradaFila); //Set referecia do novoNo para o primeiro valor(Object).
        refNoEntradaFila = novoNo;
    }

    public Object first() { //Retorna o primeiro da fila / Refatoracao em retornar No para retornar object
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila; //Pega referencia do ultimo da fila;

            while(true){
                if(primeiroNo.getRefNo() != null){
                    primeiroNo = primeiroNo.getRefNo(); //Enquanto TRUE vai passando de No em No gracas a referencia entre os NOs ate chegar no primeiro.
                }else{
                    break;
                }
            }
            return primeiroNo.getObject();
        }
        return null;
    }

    public Object dequeue() {//Retirar o primeiro valor da FILA / Refatoracao em retornar No para retornar object
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;

            while(true){
                if(primeiroNo.getRefNo() != null){
                    noAuxiliar = primeiroNo; //Salva o valor anterior ao de baixo(primeiroNo)
                    primeiroNo = primeiroNo.getRefNo(); //Enquanto TRUE vai passando de No em No gracas a referencia entre os NOs ate chegar no primeiro.
                }else{
                    noAuxiliar.setRefNo(null);//Set segundo No com referencia para NULL(Passa a ser o primeiro da fila)
                    break;
                }
            }
            return primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoEntradaFila == null ? true : false;
    }

    @Override
    public String toString() {
       String stringRetorno = "";
       No noAuxiliar = refNoEntradaFila;

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
