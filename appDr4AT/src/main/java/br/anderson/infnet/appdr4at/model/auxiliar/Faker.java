package br.anderson.infnet.appdr4at.model.auxiliar;

import java.util.Random;
import java.time.LocalDate;

public class Faker {
    public static final String[] _NOMES_ =
            {"JOSE","JOAO","ANTONIO","FRANCISCO","CARLOS",
                    "MARIA","ANA","ANTONIA","ADRIANA","JULIANA"};

    public static final String[] _SOBRENOMES_ =
            {"SILVA","SANTOS","OLIVEIRA","SOUZA","RODRIGUES",
                    "FERREIA","ALVES","PEREIRA","LIMA","GOMES"};

    public static final String[] _CPFS_  =
            {"566.101.340-06","918.959.560-21","996.308.270-00",
                    "179.888.440-24","038.446.510-20","588.034.670-68",
                    "561.867.600-14","438.131.340-24","219.662.460-80",
                    "964.230.710-39"};

    public static final String[] _DEPARTAMENTOS_ =
            {"administração","recursos humanos","financeiro","contábil",
                    "marketing e vendas","produção","logística",
                    "tecnologia da informação","jurídico","pesquisa",
                    "compras","suprimentos","atendimento ao cliente"};

    // Lista de palavras obtidas em https://www.lipsum.com/feed/html
    public static final String[] _PALAVRAS_ =
            {"Lorem","ipsum","dolor","sit","amet,","consectetur",
                    "adipiscing","elit.","Pellentesque","luctus,","magna",
                    "et","tincidunt","placerat,","magna","nisl","tristique",
                    "sapien,","ac","commodo","magna","enim","ac","velit.",
                    "Nam","et","diam","sapien.","Proin","iaculis,","tortor",
                    "a","laoreet","lobortis,","diam","odio","molestie","leo,",
                    "vel","vestibulum","metus","turpis","id","diam.","Curabitur",
                    "bibendum","ultrices","lacus,","sed","scelerisque",
                    "urna","dignissim","vulputate.","Maecenas","eu","leo",
                    "felis.","Integer","at","urna","in","mauris","volutpat",
                    "ornare","nec","non","ex.","Vestibulum","porta","est",
                    "sed","ullamcorper","tristique.","Vivamus","dignissim",
                    "laoreet","mi","at","aliquam.","Quisque","leo","risus,",
                    "efficitur","quis","arcu","id,","ultrices","vehicula",
                    "velit.","Duis","quis","lectus","venenatis,","mollis",
                    "nulla","ac,","dignissim","dolor.","Nunc","euismod",
                    "magna","sit","amet","tortor","venenatis,","at",
                    "mattis","ex","fermentum.","Vestibulum","finibus,",
                    "est","vel","molestie","mattis,","nisi","arcu",
                    "faucibus","elit,","in","pharetra","nulla","mauris",
                    "in","sapien.","Etiam","sed","maximus","justo,","eget",
                    "ultricies","nisi.","Vestibulum","ac","lacus","vitae",
                    "augue","tristique","ullamcorper.","Nulla","vehicula",
                    "finibus","nibh","ut","fermentum.","Pellentesque","interdum,",
                    "nibh","quis","bibendum","volutpat,","nisi","nisi","malesuada",
                    "nisi,","et","pharetra","ante","nunc","in","tellus.","Proin",
                    "enim","sem,","posuere","sed","suscipit","id,","posuere","sed",
                    "lectus.","Sed","dapibus","eget","eros","ac","facilisis.","Vestibulum",
                    "id","pulvinar","diam.","Pellentesque","vehicula","in","leo","nec",
                    "euismod.","Proin","egestas","est","mauris,","ut","lobortis",
                    "neque","tempor","in.","Lorem","ipsum","dolor","sit","amet,",
                    "consectetur","adipiscing","elit.","Vestibulum","blandit","sem",
                    "efficitur","maximus","suscipit.","Aliquam","quis","eros","molestie,",
                    "lacinia","urna","eget,","fringilla","augue.","Nullam","urna",
                    "mauris,","finibus","eget","neque","sit","amet,","commodo",
                    "scelerisque","neque.","Nam","quis","tortor","a","lacus",
                    "egestas","tempus.","Maecenas","commodo","fringilla","lacus",
                    "nec","ornare.","Mauris","eu","luctus","arcu,","in","commodo",
                    "elit.","Nunc","eu","urna","sem.","Mauris","blandit","magna",
                    "sit","amet","odio","sagittis,","nec","mattis","erat","posuere.",
                    "Morbi","mattis","nulla","id","libero","sollicitudin,","in",
                    "luctus","dolor","euismod.","Vivamus","vel","mattis","magna.",
                    "Curabitur","nec","ligula","a","metus","elementum","pulvinar.",
                    "In","hac","habitasse","platea","dictumst.","Nulla",
                    "ullamcorper,","sapien","vel","porttitor","semper,",
                    "lacus","arcu","interdum","sapien,","in","suscipit",
                    "mi","dui","fermentum","leo.","Ut","commodo","enim","nec",
                    "erat","rhoncus","placerat.","Praesent","felis","diam,",
                    "placerat","sed","dolor","eu,","fermentum","consequat",
                    "nisl.","Donec","tempus,","enim","sit","amet","facilisis",
                    "consectetur,","dolor","lorem","consequat","odio,","at",
                    "ornare","nisi","nunc","et","purus.","Curabitur","pretium",
                    "sagittis","neque,","et","lacinia","nisl","sollicitudin",
                    "at.","Pellentesque","aliquam","tortor","et","elit",
                    "molestie","varius.","Vivamus","vitae","ex","at","lorem",
                    "tincidunt","aliquet.","Nunc","tempor","id","quam","eu",
                    "ultrices.","Etiam","sed","auctor","odio,","nec","vehicula",
                    "mauris.","Integer","aliquet","mauris","vitae","tempus",
                    "posuere.","Quisque","nec","mattis","metus.","Aenean",
                    "eget","enim","efficitur,","sagittis","nulla"};

    public static final String getNome() {
        return
                String.format("%s %s %s", _NOMES_[new Random().nextInt(_NOMES_.length)],
                        _SOBRENOMES_[new Random().nextInt(_SOBRENOMES_.length)],
                        _SOBRENOMES_[new Random().nextInt(_SOBRENOMES_.length)]);
    }

    public static final String getCPF() {
        return _CPFS_[new Random().nextInt(_CPFS_.length)];
    }

    public static final String getDEPARTAMENTO() {
        return _DEPARTAMENTOS_[new Random().nextInt(_DEPARTAMENTOS_.length)];
    }

    public static final LocalDate getDtNasc() {
        return LocalDate.of(1970+(new Random().nextInt(100)),
                new Random().nextInt(12)+1,
                new Random().nextInt(28)+1);
    }

    public static final String getEmail(String pNome) {
        if (pNome == null) {
            pNome = getNome();
        }
        return
                String.format("%s%d@gmail.com",
                        pNome,
                        new Random().nextInt(100)
                ).replace(' ', '_');
    }

    public static final float getVALOR() {
        return (float) (new Random().nextInt(100000)/100);
    }

    public static final String getTEXTO() {
        int           lQtd = new Random().nextInt(25);
        StringBuilder sb   = new StringBuilder();
        if (lQtd<3) {
            lQtd = 3;
        }
        for (int i=0;i<lQtd;i++) {
            sb.append(_PALAVRAS_[new Random().nextInt(_PALAVRAS_.length)]);
        }
        return sb.toString().trim();
    }

    public static final Integer getNumero(Integer Ate) {
        return new Random().nextInt(Ate);
    }
}
