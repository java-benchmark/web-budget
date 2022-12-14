/*
 * Copyright (C) 2018 Arthur Gregorio, AG.Software
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.webbudget.infrastructure.feign;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

/**
 * This class is responsible of the logic to translate the province coming from the ViaCEP webservice to a readable
 * province to be used on the contact registration form
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 3.0.0, 08/04/2018
 */
public class ProvinceDeserializer extends JsonDeserializer<String> {

    /**
     * {@inheritDoc}
     *
     * @param parser
     * @param context
     * @return
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public String deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        return this.findState(parser.getText());
    }

    /**
     * Method to convert the abbreviated value of the province to the real name
     *
     * @param federateUnit the unit (abbreviated) name
     * @return the full province name
     */
    private String findState(String federateUnit) {
        switch (federateUnit) {
            case "AC":
                return "Acre";
            case "AL":
                return "Alagoas";
            case "AP":
                return "Amap??";
            case "AM":
                return "Amazonas";
            case "BA":
                return "Bahia";
            case "CE":
                return "Cear??";
            case "DF":
                return "Distrito Federal";
            case "ES":
                return "Esp??rito Santo";
            case "GO":
                return "Goi??s";
            case "MA":
                return "Maranh??o";
            case "MT":
                return "Mato Grosso";
            case "MS":
                return "Mato Grosso do Sul";
            case "MG":
                return "Minas Gerais";
            case "PA":
                return "Par??";
            case "PB":
                return "Para??ba";
            case "PR":
                return "Paran??";
            case "PE":
                return "Pernambuco";
            case "PI":
                return "Piau??";
            case "RJ":
                return "Rio de Janeiro";
            case "RN":
                return "Rio Grande do Norte";
            case "RS":
                return "Rio Grande do Sul";
            case "RO":
                return "Rond??nia";
            case "RR":
                return "Roraima";
            case "SC":
                return "Santa Catarina";
            case "SP":
                return "S??o Paulo";
            case "SE":
                return "Sergipe";
            case "TO":
                return "Tocantins";
            default:
                return "Desconhecido";
        }
    }
}
