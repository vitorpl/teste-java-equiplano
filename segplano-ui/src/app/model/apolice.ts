import { Cliente } from "./cliente";

export interface Apolice {
    id:number;
    numero: string;
    inicioVigencia: string;
    fimVigencia: string;
    placa: string;
    valor: number;
    cliente: Cliente;
    vencida: boolean;
    diasVencimento: number;
    diasParaVencimento: number;
}