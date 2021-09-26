package com.kai.hw02.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class DataServices {
    private static final ArrayList<User> users = new ArrayList<User>(){{
        add(new User("Nevin Hobden",38,"Male","Friend","New Mexico","NM"));
        add(new User("Stillman Macken",32,"Male","Friend","Arizona","AZ"));
        add(new User("Stevy Ranscomb",36,"Male","Friend","Arizona","AZ"));
        add(new User("Lynelle Garstang",22,"Female","Family","Nebraska","NE"));
        add(new User("Worth Tomek",44,"Male","Family","Missouri","MO"));
        add(new User("Bob Mendonca",32,"Male","Family","New York","NY"));
        add(new User("Serene Leeds",42,"Female","Friend","California","CA"));
        add(new User("Carin Everley",52,"Female","Work","Wisconsin","WI"));
        add(new User("Beau Mangham",28,"Male","Family","Louisiana","LA"));
        add(new User("Blithe Sizey",36,"Female","Friend","Pennsylvania","PA"));
        add(new User("Rhett Bootland",42,"Male","Family","Florida","FL"));
        add(new User("Titos Ashwood",30,"Male","Family","Minnesota","MN"));
        add(new User("Caty Chatteris",24,"Female","Family","California","CA"));
        add(new User("Taber Gavaghan",44,"Male","Family","Iowa","IA"));
        add(new User("Sadella Meth",46,"Female","Friend","Tennessee","TN"));
        add(new User("Patin Asch",38,"Male","Work","Texas","TX"));
        add(new User("Eilis Ratchford",46,"Female","Work","Florida","FL"));
        add(new User("Sammy Scorton",50,"Female","Work","Nevada","NV"));
        add(new User("Mylo Cropp",36,"Male","Friend","Michigan","MI"));
        add(new User("Jessie Brabham",32,"Male","Family","New York","NY"));
        add(new User("Ransom Van Hesteren",50,"Male","Work","Georgia","GA"));
        add(new User("Lonnie Lefeuvre",44,"Male","Friend","Florida","FL"));
        add(new User("Eddi Labbett",50,"Female","Friend","Washington","WA"));
        add(new User("Muffin Burdoun",40,"Male","Family","Florida","FL"));
        add(new User("Richy Siverns",46,"Male","Family","Illinois","IL"));
        add(new User("Benjie O'Henery",40,"Male","Family","Indiana","IN"));
        add(new User("Loni Snowden",48,"Female","Work","California","CA"));
        add(new User("Thorn Duffet",38,"Male","Work","Texas","TX"));
        add(new User("Madelyn Ornells",36,"Female","Family","Ohio","OH"));
        add(new User("Lulu Oppie",40,"Female","Friend","Maryland","MD"));
        add(new User("Heath Hadkins",32,"Male","Friend","Florida","FL"));
        add(new User("Lukas Frensch",52,"Male","Work","Texas","TX"));
        add(new User("Julieta Kear",48,"Female","Friend","Florida","FL"));
        add(new User("Mahalia Margaritelli",22,"Female","Friend","Oklahoma","OK"));
        add(new User("Blair Hansberry",40,"Female","Family","Virginia","VA"));
        add(new User("Guthrey Thomkins",30,"Male","Family","Massachusetts","MA"));
        add(new User("Erny Dayment",36,"Male","Work","Florida","FL"));
        add(new User("Krystal Bullcock",38,"Female","Family","Kansas","KS"));
        add(new User("Min Perroni",48,"Female","Family","Connecticut","CT"));
        add(new User("Jessica Spurrier",50,"Female","Work","Arkansas","AR"));
        add(new User("Cathie Kornacki",42,"Female","Family","New Jersey","NJ"));
        add(new User("Gerik Eard",48,"Male","Friend","Virginia","VA"));
        add(new User("Raff Symmons",50,"Male","Work","Florida","FL"));
        add(new User("Sashenka Chase",34,"Female","Work","Texas","TX"));
        add(new User("Prue Strute",50,"Female","Family","Virginia","VA"));
        add(new User("Kym Tapner",42,"Female","Family","New York","NY"));
        add(new User("Jaymie Klosges",24,"Male","Family","Massachusetts","MA"));
        add(new User("Tally Pickover",22,"Male","Work","Tennessee","TN"));
        add(new User("Creight Sacher",30,"Male","Friend","Arizona","AZ"));
        add(new User("Justis Shortell",36,"Male","Friend","Colorado","CO"));
        add(new User("Neill Allam",36,"Male","Friend","California","CA"));
        add(new User("Sunshine Ellery",32,"Female","Work","New Jersey","NJ"));
        add(new User("Mirella Kennedy",42,"Female","Work","Tennessee","TN"));
        add(new User("Berkley Seak",44,"Male","Family","Indiana","IN"));
        add(new User("Bradley Swett",40,"Male","Friend","Missouri","MO"));
        add(new User("Ottilie Haggerty",40,"Female","Friend","California","CA"));
        add(new User("Dixie Chestnutt",52,"Female","Friend","Mississippi","MS"));
        add(new User("Caterina O'Cooney",44,"Female","Family","Texas","TX"));
        add(new User("Georgine Zarfat",22,"Female","Work","Illinois","IL"));
        add(new User("Isaac McKinlay",38,"Male","Work","Louisiana","LA"));
        add(new User("Walt Eberst",36,"Male","Family","Georgia","GA"));
        add(new User("Vernor Allport",24,"Male","Work","Texas","TX"));
        add(new User("Barby Thomann",24,"Female","Family","Wisconsin","WI"));
        add(new User("Darrin Minithorpe",44,"Male","Work","Minnesota","MN"));
        add(new User("Hatti Stather",38,"Female","Work","South Carolina","SC"));
        add(new User("Sascha Umfrey",26,"Male","Work","California","CA"));
        add(new User("Valdemar Garrie",46,"Male","Family","Minnesota","MN"));
        add(new User("Hashim Ebbage",44,"Male","Work","Alabama","AL"));
        add(new User("Parke Gladyer",30,"Male","Work","Virginia","VA"));
        add(new User("Karlene Franschini",44,"Female","Work","Alabama","AL"));
        add(new User("Alair Calabry",34,"Male","Family","Oklahoma","OK"));
        add(new User("Lionello Apfel",24,"Male","Work","Texas","TX"));
        add(new User("Elva Gregorio",50,"Female","Friend","Iowa","IA"));
        add(new User("Rawley Vispo",30,"Male","Work","Texas","TX"));
        add(new User("Merissa Hampstead",44,"Female","Family","New York","NY"));
        add(new User("Saudra Blasetti",34,"Female","Friend","Minnesota","MN"));
        add(new User("Casey How",24,"Male","Family","Texas","TX"));
        add(new User("Ed Zoephel",24,"Male","Work","Georgia","GA"));
        add(new User("Maximo Wallen",50,"Male","Friend","Florida","FL"));
        add(new User("Bobine O'Doherty",28,"Female","Family","California","CA"));
        add(new User("Shirline Deem",38,"Female","Work","Colorado","CO"));
        add(new User("Brandyn Pisculli",32,"Male","Work","Maryland","MD"));
        add(new User("Natty Patty",30,"Male","Work","California","CA"));
        add(new User("Foster McShirie",44,"Male","Family","North Carolina","NC"));
        add(new User("Jarrid Crighton",30,"Male","Family","Texas","TX"));
        add(new User("Suki Easthope",38,"Female","Work","Florida","FL"));
        add(new User("El Furlow",50,"Male","Work","Texas","TX"));
        add(new User("Kahaleel Fidele",26,"Male","Family","Indiana","IN"));
        add(new User("Amandy Shattock",28,"Female","Friend","Florida","FL"));
        add(new User("Kerk Kull",22,"Male","Family","California","CA"));
        add(new User("Phyllis Slograve",50,"Female","Family","Massachusetts","MA"));
        add(new User("Fairfax Lovejoy",22,"Male","Friend","Arizona","AZ"));
        add(new User("Steven Patrickson",26,"Male","Friend","Colorado","CO"));
        add(new User("Goldy Christie",44,"Female","Friend","Kansas","KS"));
        add(new User("Basilius Leschelle",44,"Male","Work","Washington","WA"));
        add(new User("Dee Grass",22,"Female","Family","Maryland","MD"));
        add(new User("Rosalinde Punyer",32,"Female","Work","Oklahoma","OK"));
        add(new User("Naomi Leiden",48,"Female","Family","Texas","TX"));
        add(new User("Wylma Tuffs",34,"Female","Work","New York","NY"));
        add(new User("Vere McGannon",30,"Female","Friend","Delaware","DE"));
        add(new User("Yasmin Antos",42,"Female","Work","Florida","FL"));
        add(new User("Lovell Aleshintsev",46,"Male","Work","Texas","TX"));
        add(new User("Ree Outhwaite",50,"Female","Friend","District of Columbia","DC"));
        add(new User("Norman Maddick",32,"Male","Work","California","CA"));
        add(new User("Nobe Wedlock",42,"Male","Work","Wisconsin","WI"));
        add(new User("Raychel Compson",32,"Female","Friend","California","CA"));
        add(new User("Vassily Campos",44,"Male","Friend","Ohio","OH"));
        add(new User("Adelaide Tolle",42,"Female","Work","District of Columbia","DC"));
        add(new User("Giuseppe Greystoke",50,"Male","Work","Texas","TX"));
        add(new User("Riobard Bradfield",40,"Male","Friend","Tennessee","TN"));
        add(new User("Gilli Jerman",44,"Female","Work","New Mexico","NM"));
        add(new User("Brod Thams",30,"Male","Family","Virginia","VA"));
        add(new User("Nappy Shotbolt",40,"Male","Friend","Missouri","MO"));
        add(new User("Sigismond Stebbings",48,"Male","Work","Tennessee","TN"));
        add(new User("Candie Blaszkiewicz",46,"Female","Friend","Colorado","CO"));
        add(new User("Ramona Baum",22,"Female","Family","Louisiana","LA"));
        add(new User("Kiah Strover",36,"Female","Family","Texas","TX"));
        add(new User("Eliza Tregien",40,"Female","Friend","North Carolina","NC"));
        add(new User("Hurlee Loker",46,"Male","Family","Colorado","CO"));
        add(new User("Orlan Joesbury",38,"Male","Friend","Kentucky","KY"));
        add(new User("Berrie Lett",34,"Female","Family","California","CA"));
        add(new User("Edythe Gregorio",42,"Female","Work","District of Columbia","DC"));
        add(new User("Alys Hessle",22,"Female","Family","Maryland","MD"));
        add(new User("Chrissie Forryan",42,"Male","Family","Florida","FL"));
        add(new User("Ervin Chevin",42,"Male","Friend","Indiana","IN"));
        add(new User("Trey Kliesl",50,"Male","Friend","North Carolina","NC"));
        add(new User("Rozele Gresly",46,"Female","Work","West Virginia","WV"));
        add(new User("Hobart McGeagh",24,"Male","Work","New Jersey","NJ"));
        add(new User("Thayne Stennings",46,"Male","Family","West Virginia","WV"));
        add(new User("Annabel Codman",36,"Female","Friend","California","CA"));
        add(new User("Carine Shegog",36,"Female","Work","Minnesota","MN"));
        add(new User("Clem Uebel",46,"Male","Family","Colorado","CO"));
        add(new User("Bertrand Cardoo",28,"Male","Family","Virginia","VA"));
        add(new User("Humberto Shropshire",42,"Male","Work","Delaware","DE"));
        add(new User("Issie Lackney",28,"Female","Family","Florida","FL"));
        add(new User("Etan Gorries",46,"Male","Family","Nevada","NV"));
        add(new User("Clo Arne",34,"Female","Friend","Ohio","OH"));
        add(new User("Adora Ruggiero",32,"Female","Friend","New York","NY"));
        add(new User("Joycelin Timlett",48,"Female","Friend","Michigan","MI"));
        add(new User("Joye Maldin",22,"Female","Work","Florida","FL"));
        add(new User("Annaliese Casterou",26,"Female","Family","Virginia","VA"));
        add(new User("Filbert Allwright",50,"Male","Friend","New York","NY"));
        add(new User("Analise O'Shesnan",50,"Female","Family","Indiana","IN"));
        add(new User("Ransom Mallall",24,"Male","Friend","Mississippi","MS"));
        add(new User("Dolph Senecaux",44,"Male","Family","Connecticut","CT"));
        add(new User("Faustine Davidov",28,"Female","Work","Louisiana","LA"));
        add(new User("Ronni Camellini",30,"Female","Friend","Ohio","OH"));
        add(new User("Filia McKeggie",22,"Female","Family","Texas","TX"));
        add(new User("Jolie Sheber",46,"Female","Friend","North Carolina","NC"));
        add(new User("Gillan Punchard",36,"Female","Work","New Mexico","NM"));
        add(new User("Reid Simmens",28,"Male","Family","California","CA"));
        add(new User("Halette Leaton",28,"Female","Work","Illinois","IL"));
        add(new User("Grace Petegre",34,"Male","Work","Arkansas","AR"));
        add(new User("Janenna Nulty",50,"Female","Family","Hawaii","HI"));
        add(new User("Mike McQueen",44,"Male","Work","Florida","FL"));
        add(new User("Cristi Sherr",22,"Female","Work","Georgia","GA"));
        add(new User("Garrott Pierton",38,"Male","Friend","Nevada","NV"));
        add(new User("Ibbie Kemet",40,"Female","Work","Hawaii","HI"));
        add(new User("Sacha Cordet",40,"Female","Work","Ohio","OH"));
        add(new User("Cathe Butner",30,"Female","Friend","Florida","FL"));
        add(new User("Immanuel Kreber",34,"Male","Family","Colorado","CO"));
        add(new User("Mireille Hutson",38,"Female","Family","Florida","FL"));
        add(new User("Xavier Diplock",38,"Male","Work","Alabama","AL"));
        add(new User("Donia Coxhell",24,"Female","Friend","Iowa","IA"));
        add(new User("Nikoletta Desouza",44,"Female","Friend","Oklahoma","OK"));
        add(new User("Delainey Whitford",26,"Male","Work","Florida","FL"));
        add(new User("Consolata McKendo",48,"Female","Work","Georgia","GA"));
        add(new User("Thedric Emblen",38,"Male","Family","Florida","FL"));
        add(new User("Murial cornhill",38,"Female","Family","Iowa","IA"));
        add(new User("Alric Brastead",38,"Male","Family","Tennessee","TN"));
        add(new User("Rea Evenett",32,"Female","Work","Connecticut","CT"));
        add(new User("Arabele Duesberry",36,"Female","Work","Michigan","MI"));
        add(new User("Xenia Duffitt",40,"Female","Friend","Alabama","AL"));
        add(new User("Pris O'Leary",44,"Female","Family","Delaware","DE"));
        add(new User("Donnamarie Gorton",36,"Female","Friend","Texas","TX"));
        add(new User("Mabelle Threadgold",36,"Female","Family","Florida","FL"));
        add(new User("Aila Spick",22,"Female","Friend","Texas","TX"));
        add(new User("Oren Thurlby",46,"Male","Family","California","CA"));
        add(new User("Olivette Lampen",26,"Female","Family","Texas","TX"));
        add(new User("Saudra Barkhouse",26,"Female","Family","Florida","FL"));
        add(new User("Bevan Castellucci",46,"Male","Friend","Ohio","OH"));
        add(new User("Sonnie Hanbidge",46,"Female","Family","Pennsylvania","PA"));
        add(new User("Loy Denslow",24,"Male","Work","Texas","TX"));
        add(new User("Mona Sefton",28,"Female","Work","Wisconsin","WI"));
        add(new User("Jeremias Manoch",40,"Male","Work","California","CA"));
        add(new User("Miguelita Jori",24,"Female","Work","Tennessee","TN"));
        add(new User("Obediah Eastwell",34,"Male","Friend","Colorado","CO"));
        add(new User("Al Tallant",46,"Male","Work","Georgia","GA"));
        add(new User("Artemus Durram",48,"Male","Work","Ohio","OH"));
        add(new User("Tan Klimes",28,"Male","Work","Minnesota","MN"));
        add(new User("Abraham Pickover",26,"Male","Friend","Illinois","IL"));
        add(new User("Oralla Durtnall",44,"Female","Work","Virginia","VA"));
        add(new User("Farrah Dearlove",40,"Female","Work","Texas","TX"));
        add(new User("Moses Petrillo",34,"Male","Work","Maryland","MD"));
        add(new User("Haze Scrymgeour",36,"Male","Family","Alabama","AL"));
        add(new User("Adrian Tregale",44,"Male","Family","New Jersey","NJ"));
        add(new User("Gwyneth Pillman",46,"Female","Friend","Georgia","GA"));
        add(new User("Whitby Leatt",26,"Male","Family","Oklahoma","OK"));
        add(new User("Nancie Gwinnett",22,"Female","Family","Florida","FL"));
        add(new User("Baudoin Karlsen",38,"Male","Family","Oklahoma","OK"));
        add(new User("Konrad Howson",24,"Male","Friend","Colorado","CO"));
        add(new User("Nerti Littlepage",24,"Female","Family","Colorado","CO"));
        add(new User("Broderick Ingilson",52,"Male","Friend","Texas","TX"));
        add(new User("Sabra Gadsdon",32,"Female","Family","Iowa","IA"));
        add(new User("Josefina Leser",48,"Female","Work","New York","NY"));
        add(new User("Luisa Ticehurst",52,"Female","Friend","New York","NY"));
        add(new User("Junia Craxford",22,"Female","Friend","Indiana","IN"));
        add(new User("Ralph Salmond",22,"Male","Friend","Texas","TX"));
        add(new User("Katrine Roubeix",50,"Female","Friend","Missouri","MO"));
        add(new User("Maxim Megarry",36,"Male","Friend","Ohio","OH"));
        add(new User("Lilla Wisedale",38,"Female","Friend","Connecticut","CT"));
        add(new User("Herman Lannen",36,"Male","Work","Texas","TX"));
        add(new User("Lucais Norsister",36,"Male","Family","California","CA"));
        add(new User("Stanton Seide",38,"Male","Work","Alabama","AL"));
        add(new User("Maegan Peerless",24,"Female","Friend","Louisiana","LA"));
        add(new User("Chilton Shirer",46,"Male","Work","New Jersey","NJ"));
        add(new User("Calli Applegate",44,"Female","Family","Iowa","IA"));
        add(new User("Fransisco Frayn",28,"Male","Family","California","CA"));
        add(new User("Kimberley Jurges",28,"Female","Friend","Louisiana","LA"));
        add(new User("Oates Brotherick",26,"Male","Family","Pennsylvania","PA"));
        add(new User("Duncan Potts",24,"Male","Friend","Colorado","CO"));
        add(new User("Tony Caddie",40,"Female","Work","Texas","TX"));
        add(new User("Shoshanna Basnall",42,"Female","Family","California","CA"));
        add(new User("Hersh Glassman",30,"Male","Family","Texas","TX"));
        add(new User("Letta Hale",44,"Female","Work","California","CA"));
        add(new User("Horacio Beat",32,"Male","Work","California","CA"));
        add(new User("Amara McElroy",46,"Female","Work","Florida","FL"));
        add(new User("Viv Amort",34,"Female","Friend","Florida","FL"));
        add(new User("Minette Lally",36,"Female","Work","Texas","TX"));
        add(new User("Rowland Serle",34,"Male","Family","Idaho","ID"));
        add(new User("Cynthy Siverns",42,"Female","Work","Georgia","GA"));
        add(new User("Norma Weepers",42,"Female","Family","Virginia","VA"));
        add(new User("Adrian Goschalk",30,"Female","Work","District of Columbia","DC"));
        add(new User("Angelo Dreinan",28,"Male","Family","Oklahoma","OK"));
        add(new User("Talbot Brithman",24,"Male","Work","Maryland","MD"));
        add(new User("Doralia Madden",32,"Female","Family","New York","NY"));
        add(new User("Odell Opdenorth",36,"Male","Work","Illinois","IL"));
        add(new User("Kelvin Maber",36,"Male","Friend","Ohio","OH"));
        add(new User("Josepha Capes",48,"Female","Family","Washington","WA"));
        add(new User("Jessey Emons",32,"Male","Friend","Missouri","MO"));
        add(new User("Mirna Ingarfill",24,"Female","Friend","Illinois","IL"));
        add(new User("Fredrika Bulman",36,"Female","Friend","South Carolina","SC"));
        add(new User("Gwenora MacAllester",46,"Female","Work","Texas","TX"));
        add(new User("Kippar Cassel",24,"Male","Family","District of Columbia","DC"));
        add(new User("Nickolai Angove",34,"Male","Family","Florida","FL"));
        add(new User("Ema Rodolf",32,"Female","Friend","Illinois","IL"));
        add(new User("Ethe Stoodale",30,"Male","Friend","Louisiana","LA"));
        add(new User("Nealy Lill",42,"Male","Friend","California","CA"));
        add(new User("Alwin Dearle",40,"Male","Family","Connecticut","CT"));
        add(new User("Khalil Mar",50,"Male","Work","Georgia","GA"));
        add(new User("Meg Sansome",42,"Female","Family","Florida","FL"));
        add(new User("Malanie Balsillie",46,"Female","Work","Pennsylvania","PA"));
        add(new User("Niels Challiner",52,"Male","Friend","West Virginia","WV"));
        add(new User("Maurise Huscroft",34,"Male","Family","District of Columbia","DC"));
        add(new User("Rozamond Martensen",30,"Female","Work","Connecticut","CT"));
        add(new User("Stanfield Verzey",40,"Male","Friend","North Carolina","NC"));
        add(new User("Chadwick Remer",28,"Male","Family","Texas","TX"));
        add(new User("Wenona Shemmin",50,"Female","Work","Ohio","OH"));
        add(new User("Ardelis Snoding",44,"Female","Work","New York","NY"));
        add(new User("Carena Downie",38,"Female","Friend","Illinois","IL"));
        add(new User("Lucky Crafter",48,"Female","Work","Florida","FL"));
        add(new User("Thain Gauld",46,"Male","Friend","Virginia","VA"));
        add(new User("Etta Boyde",42,"Female","Friend","Virginia","VA"));
        add(new User("Georgiana Gregorowicz",30,"Female","Friend","Florida","FL"));
        add(new User("Mirelle Favey",50,"Female","Friend","Arizona","AZ"));
        add(new User("Arabele Edwardes",40,"Female","Friend","Florida","FL"));
        add(new User("Beulah Beecker",30,"Female","Family","California","CA"));
        add(new User("Jobi De la Feld",30,"Female","Work","Texas","TX"));
        add(new User("Isac Oels",36,"Male","Friend","Florida","FL"));
        add(new User("Jennilee Chatelain",34,"Female","Friend","Illinois","IL"));
        add(new User("Appolonia Cathery",24,"Female","Friend","Oregon","OR"));
        add(new User("Domingo Courtin",26,"Male","Family","District of Columbia","DC"));
        add(new User("Tanny Edmett",50,"Male","Family","Utah","UT"));
        add(new User("Konstance Snoding",38,"Female","Work","Florida","FL"));
        add(new User("Collen Symms",28,"Female","Work","New York","NY"));
        add(new User("Tobe Mohamed",30,"Female","Family","New York","NY"));
        add(new User("Brad Tierny",38,"Male","Friend","Arizona","AZ"));
        add(new User("Eddie Eick",26,"Female","Family","California","CA"));
        add(new User("Hewet Haynes",48,"Male","Work","Florida","FL"));
        add(new User("Paulie Aleevy",34,"Female","Work","Minnesota","MN"));
        add(new User("Clemente Hendrix",38,"Male","Work","Illinois","IL"));
        add(new User("Susan Buswell",46,"Female","Family","Kansas","KS"));
        add(new User("Karyl Hannant",34,"Female","Family","Washington","WA"));
        add(new User("Corrie Flade",28,"Female","Family","Florida","FL"));
        add(new User("Reade McCumesky",40,"Male","Family","California","CA"));
        add(new User("Fran Riall",34,"Female","Friend","Minnesota","MN"));
        add(new User("Ellene Wyness",46,"Female","Family","Nevada","NV"));
        add(new User("Giffy Brisard",40,"Male","Work","Florida","FL"));
        add(new User("Victor Westoff",42,"Male","Work","Texas","TX"));
        add(new User("Pierette Wilber",52,"Female","Friend","Iowa","IA"));
        add(new User("Loralee MacKerley",48,"Female","Friend","District of Columbia","DC"));
        add(new User("Clerc Cavee",40,"Male","Friend","Texas","TX"));
        add(new User("Seymour Gladyer",30,"Male","Friend","Indiana","IN"));
        add(new User("Jobye Atyea",46,"Female","Friend","Ohio","OH"));
        add(new User("Tiffi McLaughlan",40,"Female","Family","Tennessee","TN"));
        add(new User("Edgar Gatfield",36,"Male","Work","Kentucky","KY"));
        add(new User("Cesare Kolis",34,"Male","Friend","Nebraska","NE"));
        add(new User("Essie Ramas",32,"Female","Work","Texas","TX"));
        add(new User("Toma Jeynes",22,"Female","Friend","Tennessee","TN"));
        add(new User("Dud Hunnybun",52,"Male","Family","Texas","TX"));
        add(new User("Dania Troak",32,"Female","Friend","New York","NY"));
        add(new User("Gerianna Spiaggia",30,"Female","Work","Massachusetts","MA"));
        add(new User("Osmund Stagge",32,"Male","Friend","Louisiana","LA"));
        add(new User("Fitzgerald Kruger",26,"Male","Work","Louisiana","LA"));
        add(new User("Olympie Goodisson",38,"Female","Friend","West Virginia","WV"));
        add(new User("Kelley Rudwell",36,"Male","Friend","New York","NY"));
        add(new User("Millard Bowring",22,"Male","Family","Florida","FL"));
        add(new User("Clemente Bricknall",32,"Male","Family","Alabama","AL"));
        add(new User("Kennan Broadfield",28,"Male","Work","Connecticut","CT"));
        add(new User("Chucho Coneley",38,"Male","Friend","Texas","TX"));
        add(new User("Timotheus Georg",46,"Male","Family","Ohio","OH"));
        add(new User("Humbert Coppens",26,"Male","Family","Massachusetts","MA"));
        add(new User("Janine Bentley",42,"Female","Friend","Utah","UT"));
        add(new User("Eduino Snelle",46,"Male","Family","Illinois","IL"));
        add(new User("Gayle Siebert",28,"Male","Work","Texas","TX"));
        add(new User("Leontine Pilbeam",38,"Female","Work","California","CA"));
        add(new User("Rosella Lehr",38,"Female","Family","Michigan","MI"));
        add(new User("Blondie Urlin",24,"Female","Family","California","CA"));
        add(new User("Valeda Snasdell",36,"Female","Family","South Dakota","SD"));
        add(new User("Hamnet Streather",32,"Male","Work","Arkansas","AR"));
        add(new User("Hanson Althrope",34,"Male","Friend","Connecticut","CT"));
        add(new User("Christophorus Morais",50,"Male","Work","California","CA"));
        add(new User("Kev Medford",38,"Male","Work","Texas","TX"));
        add(new User("Gwenni Scandrett",50,"Female","Family","Kansas","KS"));
        add(new User("Horace Whittier",50,"Male","Friend","California","CA"));
        add(new User("Josephine Kopp",28,"Female","Friend","District of Columbia","DC"));
        add(new User("Chrisy Taffee",34,"Male","Friend","Ohio","OH"));
        add(new User("Aldo Hannaway",46,"Male","Family","Florida","FL"));
        add(new User("Markus Firsby",28,"Male","Friend","Washington","WA"));
        add(new User("Norma Rummings",46,"Female","Family","New York","NY"));
        add(new User("Giorgio Wortley",50,"Male","Friend","Oklahoma","OK"));
        add(new User("Sander Pinyon",32,"Male","Work","Virginia","VA"));
        add(new User("Ilene Duckerin",34,"Female","Friend","Illinois","IL"));
        add(new User("Amble Brixham",32,"Male","Friend","Pennsylvania","PA"));
        add(new User("Grange Hearnshaw",46,"Male","Work","New York","NY"));
        add(new User("Roxie Absalom",36,"Female","Family","Texas","TX"));
        add(new User("Lowell Paradin",32,"Male","Friend","Washington","WA"));
        add(new User("Ashby Grisbrook",40,"Male","Friend","Texas","TX"));
        add(new User("Celinda Ludlam",38,"Female","Family","New Jersey","NJ"));
        add(new User("Donalt Burtwell",32,"Male","Work","California","CA"));
        add(new User("Elsy Matthis",34,"Female","Family","Ohio","OH"));
        add(new User("Jefferson Juett",46,"Male","Friend","California","CA"));
        add(new User("Warde Bick",24,"Male","Work","Alabama","AL"));
        add(new User("Davon Mathwin",52,"Male","Work","Illinois","IL"));
        add(new User("Franky Brackenbury",42,"Female","Friend","New York","NY"));
        add(new User("Ainslie Huband",42,"Female","Friend","California","CA"));
        add(new User("Jone Pascho",24,"Male","Family","New York","NY"));
        add(new User("Jonathan Bohlmann",28,"Male","Family","New Mexico","NM"));
        add(new User("Dixie Shilstone",26,"Female","Work","California","CA"));
        add(new User("Roscoe Liffey",26,"Male","Work","California","CA"));
        add(new User("Tresa Mandeville",50,"Female","Work","Missouri","MO"));
        add(new User("Doug Mulbery",24,"Male","Family","Nevada","NV"));
        add(new User("Dannie Heggison",26,"Male","Friend","Tennessee","TN"));
        add(new User("Cordi Simeons",30,"Female","Work","Ohio","OH"));
        add(new User("Nonna Lander",26,"Female","Family","Pennsylvania","PA"));
        add(new User("Dannie Kennefick",42,"Female","Work","Illinois","IL"));
        add(new User("Krishnah Gowry",32,"Male","Family","West Virginia","WV"));
        add(new User("Katalin O'Mohun",46,"Female","Friend","South Carolina","SC"));
        add(new User("Emmi Nasey",40,"Female","Work","Georgia","GA"));
        add(new User("Breena Wickes",50,"Female","Family","Michigan","MI"));
        add(new User("Portia July",40,"Female","Friend","Texas","TX"));
        add(new User("Adelind Habard",32,"Female","Work","Florida","FL"));
        add(new User("Ailyn Cordeiro",28,"Female","Friend","Massachusetts","MA"));
        add(new User("Hobey Warkup",36,"Male","Friend","Georgia","GA"));
        add(new User("Valera Walton",42,"Female","Friend","New York","NY"));
        add(new User("Susanetta Rymell",44,"Female","Friend","Texas","TX"));
        add(new User("Fransisco Daudray",40,"Male","Family","Idaho","ID"));
        add(new User("Edlin Folliss",26,"Male","Friend","New York","NY"));
        add(new User("Rudie Pendlebury",32,"Male","Family","Nevada","NV"));
        add(new User("Chet Sendall",34,"Male","Family","Virginia","VA"));
        add(new User("Findlay Lockett",38,"Male","Friend","California","CA"));
        add(new User("Iago Glading",36,"Male","Family","Kansas","KS"));
        add(new User("Mandel Van Son",26,"Male","Work","Illinois","IL"));
        add(new User("Ricki Babonau",44,"Male","Family","California","CA"));
        add(new User("Jake Eliet",38,"Male","Family","Texas","TX"));
        add(new User("Tomi Withinshaw",24,"Female","Friend","Minnesota","MN"));
        add(new User("Giffie Frediani",36,"Male","Work","California","CA"));
        add(new User("Neely Fifield",50,"Female","Work","Florida","FL"));
        add(new User("Hamid Smail",26,"Male","Work","Georgia","GA"));
        add(new User("Gael Ibarra",46,"Female","Work","Florida","FL"));
        add(new User("Bary Marieton",40,"Male","Work","Minnesota","MN"));
        add(new User("Felicia Benedick",30,"Female","Family","Michigan","MI"));
        add(new User("Bendick MacGragh",42,"Male","Work","Delaware","DE"));
        add(new User("Carmon Dowell",34,"Female","Work","Alabama","AL"));
        add(new User("Elsey Sayre",32,"Female","Family","North Carolina","NC"));
        add(new User("Stormie Becks",52,"Female","Friend","Louisiana","LA"));
        add(new User("Morey Deering",34,"Male","Work","Texas","TX"));
        add(new User("Aryn Madill",34,"Female","Family","New York","NY"));
        add(new User("Barbaraanne Pridgeon",38,"Female","Work","Colorado","CO"));
        add(new User("Krispin Gouldthorpe",28,"Male","Work","Texas","TX"));
        add(new User("Traci Regnard",28,"Female","Friend","Missouri","MO"));
        add(new User("Myrilla Brobyn",26,"Female","Work","Texas","TX"));
        add(new User("Dorey Cathel",40,"Female","Family","New York","NY"));
        add(new User("Isaak Reubens",50,"Male","Friend","Michigan","MI"));
        add(new User("Ardelle Charnley",50,"Female","Friend","District of Columbia","DC"));
        add(new User("Mackenzie Tregidgo",48,"Male","Work","Minnesota","MN"));
        add(new User("Putnem Carlone",42,"Male","Work","Idaho","ID"));
        add(new User("Artair Deniskevich",36,"Male","Friend","Massachusetts","MA"));
        add(new User("Grady Winscom",24,"Male","Friend","Texas","TX"));
        add(new User("Care Fison",26,"Male","Friend","Alabama","AL"));
        add(new User("Katlin Aplin",50,"Female","Friend","Tennessee","TN"));
        add(new User("Dukey Wannell",24,"Male","Family","Texas","TX"));
        add(new User("Marti Sainz",22,"Female","Work","Maryland","MD"));
        add(new User("Nanni Longhi",30,"Female","Work","California","CA"));
        add(new User("Tisha Skeat",48,"Female","Family","Florida","FL"));
        add(new User("Zachary Gerritzen",24,"Male","Work","Florida","FL"));
        add(new User("Welch Bazeley",34,"Male","Family","Missouri","MO"));
        add(new User("Betti Farncomb",46,"Female","Family","Louisiana","LA"));
        add(new User("Andree Figgen",28,"Female","Family","Louisiana","LA"));
        add(new User("Earl Mawdsley",46,"Male","Family","New York","NY"));
        add(new User("Loydie Oakley",32,"Male","Family","California","CA"));
        add(new User("Micah Camoys",42,"Male","Family","Louisiana","LA"));
        add(new User("Gillie Macveigh",30,"Female","Work","Oklahoma","OK"));
        add(new User("Hobart Karlsen",26,"Male","Friend","California","CA"));
        add(new User("Kriste Polhill",28,"Female","Work","North Carolina","NC"));
        add(new User("Rozanne McSpirron",24,"Female","Family","District of Columbia","DC"));
        add(new User("Norma Michelmore",42,"Female","Work","Pennsylvania","PA"));
        add(new User("Rivkah Sprott",34,"Female","Work","Georgia","GA"));
        add(new User("Lonee Faulkes",40,"Female","Work","Florida","FL"));
        add(new User("Curry Dagless",24,"Male","Family","Pennsylvania","PA"));
        add(new User("Viviana Caldera",22,"Female","Friend","Colorado","CO"));
        add(new User("Eddie Wyer",40,"Female","Friend","New York","NY"));
        add(new User("Laryssa Castaignet",28,"Female","Friend","Texas","TX"));
        add(new User("Merline Dorricott",24,"Female","Friend","Indiana","IN"));
        add(new User("Sharleen Puddan",34,"Female","Family","Texas","TX"));
        add(new User("Jill Wilks",52,"Female","Work","Texas","TX"));
        add(new User("Sigfrid Hinsch",52,"Male","Work","Virginia","VA"));
        add(new User("Alexander Hugnet",36,"Male","Work","Texas","TX"));
        add(new User("Laureen Honatsch",50,"Female","Friend","Pennsylvania","PA"));
        add(new User("Carmella Godehard.sf",32,"Female","Friend","Ohio","OH"));
        add(new User("Theressa Fiorentino",50,"Female","Family","Florida","FL"));
        add(new User("Derwin Netting",38,"Male","Work","Connecticut","CT"));
        add(new User("Janaye Mingauld",46,"Female","Work","Pennsylvania","PA"));
        add(new User("Quintana Trollope",36,"Female","Work","Pennsylvania","PA"));
        add(new User("Cherilynn Doudny",28,"Female","Family","District of Columbia","DC"));
        add(new User("Nicole Sommerled",22,"Female","Family","Delaware","DE"));
        add(new User("Val Wathan",32,"Female","Family","Delaware","DE"));
        add(new User("Ivett Mackilpatrick",40,"Female","Work","Florida","FL"));
        add(new User("Maurice Iddon",48,"Male","Work","New Jersey","NJ"));
        add(new User("Gery Janouch",32,"Male","Friend","New Mexico","NM"));
        add(new User("Win Waltering",38,"Male","Family","Oklahoma","OK"));
        add(new User("Deni Dommett",24,"Female","Friend","Michigan","MI"));
        add(new User("Sonni Cosser",50,"Female","Work","California","CA"));
        add(new User("Sayre Armor",40,"Female","Family","Virginia","VA"));
        add(new User("Donnell Mousdall",38,"Male","Friend","Minnesota","MN"));
        add(new User("Timmy Towndrow",32,"Male","Family","Pennsylvania","PA"));
        add(new User("Ivory Facer",24,"Female","Friend","Florida","FL"));
        add(new User("Eilis Fullalove",24,"Female","Family","Colorado","CO"));
        add(new User("Tedra McMechan",34,"Female","Family","Florida","FL"));
        add(new User("Lucinda Shear",30,"Female","Work","District of Columbia","DC"));
        add(new User("Brigham Domini",48,"Male","Work","Missouri","MO"));
        add(new User("Urbano Eggle",34,"Male","Friend","Pennsylvania","PA"));
        add(new User("Donavon Mincini",26,"Male","Work","Minnesota","MN"));
        add(new User("Devonna Bulfit",34,"Female","Friend","Florida","FL"));
        add(new User("Winslow Warboy",48,"Male","Friend","California","CA"));
        add(new User("Daisie Caldroni",30,"Female","Friend","Alabama","AL"));
        add(new User("Rozalie Damarell",30,"Female","Family","Florida","FL"));
        add(new User("Jesselyn Panner",22,"Female","Family","Indiana","IN"));
        add(new User("Hagan Worrell",50,"Male","Friend","Georgia","GA"));
        add(new User("Andy Ary",32,"Male","Work","California","CA"));
        add(new User("Lonnie Barbary",42,"Female","Family","Florida","FL"));
        add(new User("Ignaz Ackers",28,"Male","Family","Indiana","IN"));
        add(new User("Rosalyn Farbrother",34,"Female","Work","Texas","TX"));
        add(new User("Bernice Blune",40,"Female","Friend","Colorado","CO"));
        add(new User("Oliy Gianolini",24,"Female","Work","California","CA"));
        add(new User("Pavia Perceval",24,"Female","Family","Texas","TX"));
        add(new User("Haley Belfrage",38,"Male","Family","Texas","TX"));
        add(new User("Rainer Wrist",38,"Male","Family","New Jersey","NJ"));
        add(new User("Tye Ormiston",36,"Male","Friend","Georgia","GA"));
        add(new User("Lloyd Sent",48,"Male","Friend","California","CA"));
        add(new User("Mina Runcie",24,"Female","Work","West Virginia","WV"));
        add(new User("Quincey McLucas",26,"Male","Work","Pennsylvania","PA"));
        add(new User("Bebe Sharvell",38,"Female","Family","California","CA"));
        add(new User("Hamid Lounds",24,"Male","Work","Missouri","MO"));
        add(new User("Mariann Winsper",38,"Female","Friend","Texas","TX"));
        add(new User("Alva Bony",22,"Male","Work","Virginia","VA"));
        add(new User("Orv Burdin",34,"Male","Friend","Texas","TX"));
        add(new User("Adrien Seavers",32,"Male","Friend","Indiana","IN"));
        add(new User("Edin Twiname",48,"Female","Friend","North Carolina","NC"));
        add(new User("Allene Alenichev",38,"Female","Friend","Florida","FL"));
        add(new User("Caren Rose",48,"Female","Family","Ohio","OH"));
        add(new User("Bobbette Britch",42,"Female","Family","Indiana","IN"));
        add(new User("Rufe Marjot",46,"Male","Family","Minnesota","MN"));
        add(new User("Mozelle Sapson",38,"Female","Friend","Florida","FL"));
        add(new User("Wally Lindenberg",24,"Male","Work","Oklahoma","OK"));
        add(new User("Emelyne Quinnette",28,"Female","Work","Pennsylvania","PA"));
        add(new User("Lura Avery",32,"Female","Family","New York","NY"));
        add(new User("Sayers O'Spellissey",36,"Male","Work","California","CA"));
        add(new User("Faunie Insole",34,"Female","Friend","South Carolina","SC"));
        add(new User("Lexie Emma",50,"Female","Family","California","CA"));
        add(new User("Avril Fend",34,"Female","Work","California","CA"));
        add(new User("Hersh Deegan",42,"Male","Family","California","CA"));
        add(new User("Jeno Flahy",28,"Male","Family","Massachusetts","MA"));
        add(new User("Aubrette Gridley",22,"Female","Friend","Kansas","KS"));
        add(new User("Odey Lonergan",26,"Male","Friend","Washington","WA"));
        add(new User("Adelice Boagey",30,"Female","Friend","Florida","FL"));
        add(new User("Milton Reisk",44,"Male","Friend","Georgia","GA"));
        add(new User("Kary Parnell",24,"Female","Family","Florida","FL"));
        add(new User("Charyl Furnell",46,"Female","Family","Wisconsin","WI"));
        add(new User("Johan Lavigne",34,"Male","Family","Arizona","AZ"));
        add(new User("Wylie McGirr",22,"Male","Family","Alaska","AK"));
        add(new User("Rouvin Stuttman",46,"Male","Family","Illinois","IL"));
        add(new User("Rodd Cosgreave",24,"Male","Family","Ohio","OH"));
        add(new User("Janot Derell",30,"Female","Friend","Louisiana","LA"));
        add(new User("Jessi Odlin",24,"Female","Friend","New York","NY"));
        add(new User("Charisse Tynemouth",26,"Female","Friend","Florida","FL"));
        add(new User("Barbara Hailes",24,"Female","Family","New York","NY"));
        add(new User("Arluene Grut",38,"Female","Friend","California","CA"));
        add(new User("Barbe Keemer",22,"Female","Friend","New York","NY"));
        add(new User("Lockwood Bloxholm",32,"Male","Friend","Texas","TX"));
        add(new User("Joelynn Dabney",32,"Female","Family","Pennsylvania","PA"));
        add(new User("Skye Alsobrook",32,"Male","Family","Pennsylvania","PA"));
        add(new User("Fey Mountford",32,"Female","Friend","Florida","FL"));
        add(new User("Saleem Hawk",42,"Male","Friend","Arizona","AZ"));
        add(new User("Ewen Shropsheir",48,"Male","Work","Virginia","VA"));
        add(new User("Holly-anne Wolfenden",46,"Female","Work","Nevada","NV"));
        add(new User("Valery Raccio",52,"Female","Work","California","CA"));
        add(new User("Raina Nowak",44,"Female","Work","Utah","UT"));
        add(new User("Belle Donalson",22,"Female","Work","California","CA"));
        add(new User("Jude Reimers",30,"Male","Friend","Florida","FL"));
        add(new User("Lorry Cosham",42,"Female","Friend","District of Columbia","DC"));
        add(new User("Edouard Barz",26,"Male","Family","California","CA"));
        add(new User("Nissa Feragh",44,"Female","Family","Pennsylvania","PA"));
        add(new User("Shandie Gavriel",36,"Female","Work","New Mexico","NM"));
        add(new User("Catha Pedreschi",34,"Female","Family","Pennsylvania","PA"));
        add(new User("Jarrid Eversley",26,"Male","Friend","Arizona","AZ"));
        add(new User("Sergei Greedier",44,"Male","Work","Georgia","GA"));
        add(new User("Danya O'Collopy",26,"Male","Work","District of Columbia","DC"));
        add(new User("Fabio Gagg",32,"Male","Friend","California","CA"));
        add(new User("Shaughn Cruxton",26,"Male","Work","Louisiana","LA"));
        add(new User("Jobye Leigh",46,"Female","Work","California","CA"));
        add(new User("Thorndike Handke",44,"Male","Friend","Nebraska","NE"));
        add(new User("Lilla Trenchard",44,"Female","Friend","Florida","FL"));
        add(new User("Odetta Di Pietro",42,"Female","Family","Texas","TX"));
        add(new User("Dore Millins",22,"Female","Friend","Kansas","KS"));
        add(new User("Marten Roistone",42,"Male","Family","New York","NY"));
        add(new User("Jaime Yashin",32,"Male","Family","Minnesota","MN"));
        add(new User("Odie Phifer",36,"Male","Friend","Alabama","AL"));
        add(new User("Emmanuel Farragher",28,"Male","Friend","Pennsylvania","PA"));
        add(new User("Zed Oldman",24,"Male","Friend","South Carolina","SC"));
        add(new User("Arlene Garmey",44,"Female","Work","Minnesota","MN"));
        add(new User("Yul Ansteys",34,"Male","Family","Florida","FL"));
        add(new User("Violette Brunet",40,"Female","Work","Texas","TX"));
        add(new User("Bernadine Minerdo",42,"Female","Work","Kentucky","KY"));
        add(new User("Georges Ferenczy",44,"Male","Family","Kentucky","KY"));
        add(new User("Lorri Kilmary",24,"Female","Work","District of Columbia","DC"));
        add(new User("Ryon Wurst",30,"Male","Family","Florida","FL"));
        add(new User("Talbot Wildin",38,"Male","Friend","Pennsylvania","PA"));
        add(new User("Chrotoem Kilminster",24,"Male","Friend","Arizona","AZ"));
        add(new User("Sabina Halshaw",34,"Female","Friend","Ohio","OH"));
        add(new User("Edvard Wegman",48,"Male","Work","Kentucky","KY"));
        add(new User("Rockie Elen",42,"Male","Family","Texas","TX"));
        add(new User("Grete Sexten",46,"Female","Family","California","CA"));
        add(new User("Ramonda Astill",28,"Female","Family","Florida","FL"));
        add(new User("Ciro Hunter",36,"Male","Family","Illinois","IL"));
        add(new User("Trude Hearne",36,"Female","Family","Ohio","OH"));
        add(new User("Giacomo Embleton",30,"Male","Work","Florida","FL"));
        add(new User("Dale Darby",38,"Male","Work","Arizona","AZ"));
        add(new User("Fraze Lukesch",42,"Male","Work","California","CA"));
        add(new User("Gleda Taggett",24,"Female","Family","Pennsylvania","PA"));
        add(new User("Mattheus Greep",40,"Male","Friend","Hawaii","HI"));
        add(new User("Bertie Seemmonds",26,"Male","Work","New Jersey","NJ"));
        add(new User("Caldwell Lashford",48,"Male","Work","Florida","FL"));
        add(new User("Tana Wallice",24,"Female","Family","Ohio","OH"));
        add(new User("Roman Abramovic",26,"Male","Work","Kansas","KS"));
        add(new User("Jonie Chilcott",42,"Female","Family","California","CA"));
        add(new User("Drona Murison",38,"Female","Work","Texas","TX"));
        add(new User("Cathlene Licari",34,"Female","Friend","Missouri","MO"));
        add(new User("Rhona Chateau",46,"Female","Friend","Louisiana","LA"));
        add(new User("Archy Zimek",52,"Male","Family","Pennsylvania","PA"));
        add(new User("Rianon Hirtz",46,"Female","Friend","Ohio","OH"));
        add(new User("Solly Cornthwaite",32,"Male","Family","South Carolina","SC"));
        add(new User("Immanuel Mowling",42,"Male","Work","Florida","FL"));
        add(new User("Guthrie Warman",30,"Male","Work","California","CA"));
        add(new User("Rodger Redfearn",36,"Male","Work","California","CA"));
        add(new User("Valentino Everingham",48,"Male","Work","Florida","FL"));
        add(new User("Sergent Hanington",36,"Male","Work","California","CA"));
        add(new User("Chrisse Juschka",40,"Male","Family","Missouri","MO"));
        add(new User("Martino Noorwood",32,"Male","Friend","Washington","WA"));
        add(new User("Gray Benion",30,"Male","Family","Alabama","AL"));
        add(new User("Rodolphe Frankel",26,"Male","Friend","Nebraska","NE"));
        add(new User("Perry Payler",46,"Male","Family","New York","NY"));
        add(new User("Andrea Wybrew",26,"Female","Work","New Jersey","NJ"));
        add(new User("Fowler Dable",46,"Male","Work","Texas","TX"));
        add(new User("Kathleen Maudling",48,"Female","Work","Massachusetts","MA"));
        add(new User("Holt Silveston",34,"Male","Work","California","CA"));
        add(new User("Christel Pearcy",50,"Female","Friend","Georgia","GA"));
        add(new User("Tess Boise",46,"Female","Friend","Missouri","MO"));
        add(new User("Lyman McCague",28,"Male","Friend","Texas","TX"));
        add(new User("Adolph Scanes",34,"Male","Friend","Alabama","AL"));
        add(new User("Rinaldo Castel",28,"Male","Work","Florida","FL"));
        add(new User("Tome Gotecliffe",46,"Male","Friend","New York","NY"));
        add(new User("Anne-marie Stobbes",24,"Female","Work","Texas","TX"));
        add(new User("Bronny Preshous",30,"Male","Family","Tennessee","TN"));
        add(new User("Carl Blackster",34,"Male","Friend","Florida","FL"));
        add(new User("Birk Rosenwasser",38,"Male","Friend","California","CA"));
        add(new User("Boony Flaune",52,"Male","Family","Louisiana","LA"));
        add(new User("Karim Jacobowits",36,"Male","Family","New York","NY"));
        add(new User("Ailbert Kindread",44,"Male","Work","California","CA"));
        add(new User("Freeman Partrick",48,"Male","Family","Texas","TX"));
        add(new User("Roxy Janc",24,"Female","Family","District of Columbia","DC"));
        add(new User("Vick Melliard",50,"Male","Work","North Carolina","NC"));
        add(new User("Alastair Plunkett",38,"Male","Friend","California","CA"));
        add(new User("Florance Musicka",50,"Female","Family","Michigan","MI"));
        add(new User("Valentine Hagyard",46,"Female","Friend","District of Columbia","DC"));
        add(new User("Kore Janicek",24,"Female","Friend","Texas","TX"));
        add(new User("Constantine Craddy",24,"Female","Family","New York","NY"));
        add(new User("Eadmund Tolan",40,"Male","Family","Florida","FL"));
        add(new User("Wendy Franzonello",40,"Female","Friend","Utah","UT"));
        add(new User("Nedda Lytton",40,"Female","Family","District of Columbia","DC"));
        add(new User("Jaime Crisp",50,"Female","Work","Utah","UT"));
        add(new User("Rodd Lissemore",30,"Male","Friend","California","CA"));
        add(new User("Leonanie Brucker",28,"Female","Friend","California","CA"));
        add(new User("Bertram Espadero",36,"Male","Family","New Jersey","NJ"));
        add(new User("Haskel Channing",44,"Male","Friend","California","CA"));
        add(new User("Pierre Nobbs",34,"Male","Friend","Mississippi","MS"));
        add(new User("Arleta Gravey",48,"Female","Friend","Florida","FL"));
        add(new User("Quintana Blaik",32,"Female","Friend","Ohio","OH"));
        add(new User("Nahum Labbett",50,"Male","Friend","Illinois","IL"));
        add(new User("Sumner Logue",44,"Male","Family","Washington","WA"));
        add(new User("Kim McQuilty",50,"Female","Family","Texas","TX"));
        add(new User("Berkley Wharlton",48,"Male","Work","Oklahoma","OK"));
        add(new User("Reginauld Thorrold",40,"Male","Work","Pennsylvania","PA"));
        add(new User("Zach Klaff",22,"Male","Family","Wisconsin","WI"));
        add(new User("Jock Verrills",38,"Male","Family","District of Columbia","DC"));
        add(new User("Tracey Mattek",48,"Male","Friend","Maryland","MD"));
        add(new User("Horatius Assinder",52,"Male","Friend","New York","NY"));
        add(new User("Blondelle Trunchion",44,"Female","Family","Illinois","IL"));
        add(new User("Leon Earnshaw",50,"Male","Family","Alaska","AK"));
        add(new User("Courtney Fawke",48,"Female","Friend","Georgia","GA"));
        add(new User("Wolfy Buckenham",22,"Male","Friend","Georgia","GA"));
        add(new User("Danika Dayment",36,"Female","Family","Texas","TX"));
        add(new User("Dominik Stockau",26,"Male","Family","Pennsylvania","PA"));
        add(new User("Livvyy Aubry",44,"Female","Family","Texas","TX"));
        add(new User("Farr Locard",44,"Male","Family","Nevada","NV"));
        add(new User("Yard Ingleton",52,"Male","Family","Connecticut","CT"));
        add(new User("Lindsey Patershall",50,"Male","Family","Florida","FL"));
        add(new User("Randy Vanyukhin",40,"Male","Family","Florida","FL"));
        add(new User("Nissie Barhems",24,"Female","Work","Colorado","CO"));
        add(new User("Tommi Potzold",40,"Female","Friend","Louisiana","LA"));
        add(new User("Mitch Farens",44,"Male","Friend","Kentucky","KY"));
        add(new User("Pennie Tipton",50,"Female","Work","California","CA"));
        add(new User("Dave Windmill",44,"Male","Work","Illinois","IL"));
        add(new User("Fulvia Puvia",22,"Female","Family","Kansas","KS"));
        add(new User("Armando Pavelka",44,"Male","Work","Missouri","MO"));
        add(new User("Phelia Pybus",52,"Female","Friend","Pennsylvania","PA"));
        add(new User("Grete D'Ambrosi",36,"Female","Friend","California","CA"));
        add(new User("Garrott Coale",38,"Male","Family","Florida","FL"));
        add(new User("Theda Brock",48,"Female","Family","Tennessee","TN"));
        add(new User("Tamqrah Felton",28,"Female","Work","Texas","TX"));
        add(new User("Lanie Taile",40,"Female","Friend","Utah","UT"));
        add(new User("Agnes Barkaway",30,"Female","Family","Illinois","IL"));
        add(new User("Arel Burndred",44,"Male","Family","Georgia","GA"));
        add(new User("Ki Likly",40,"Female","Family","Texas","TX"));
        add(new User("Layla Gosalvez",34,"Female","Work","Minnesota","MN"));
        add(new User("Marcus La Vigne",50,"Male","Work","South Carolina","SC"));
        add(new User("Franny Winspur",32,"Female","Family","Florida","FL"));
        add(new User("Cord Darree",28,"Male","Friend","California","CA"));
        add(new User("Nancy Cullin",50,"Female","Family","California","CA"));
        add(new User("Benton Bennough",42,"Male","Friend","Colorado","CO"));
        add(new User("Berthe Mateiko",28,"Female","Friend","New Jersey","NJ"));
        add(new User("Buffy Galfour",24,"Female","Family","Mississippi","MS"));
        add(new User("Mellicent Drummond",34,"Female","Family","Ohio","OH"));
        add(new User("Dick Billison",32,"Male","Friend","Indiana","IN"));
        add(new User("Raynor Kimbling",34,"Male","Friend","Arizona","AZ"));
        add(new User("Meghan de Guerre",26,"Female","Work","Pennsylvania","PA"));
        add(new User("Erek Grimmett",26,"Male","Work","Colorado","CO"));
        add(new User("Danika Donisi",40,"Female","Family","North Carolina","NC"));
        add(new User("Ric Thoma",32,"Male","Friend","Tennessee","TN"));
        add(new User("Dukey Sloley",42,"Male","Work","South Carolina","SC"));
        add(new User("Beauregard Lidgely",34,"Male","Work","California","CA"));
        add(new User("Rita Segrave",48,"Female","Work","Pennsylvania","PA"));
        add(new User("Vin Boykett",30,"Male","Family","Texas","TX"));
        add(new User("Claus Bastone",50,"Male","Friend","West Virginia","WV"));
        add(new User("Britta Micka",32,"Female","Friend","Missouri","MO"));
        add(new User("Miner Tidbold",32,"Male","Work","Texas","TX"));
        add(new User("Charmion Ogilby",42,"Female","Work","California","CA"));
        add(new User("Hugibert Leighton",40,"Male","Family","Alabama","AL"));
        add(new User("Dunstan Extal",44,"Male","Work","Georgia","GA"));
        add(new User("Cortney Seabert",26,"Female","Friend","Illinois","IL"));
        add(new User("Lorrie Cattellion",44,"Male","Work","Washington","WA"));
        add(new User("Ainsley Twist",24,"Female","Friend","New York","NY"));
        add(new User("Thain Tommasi",34,"Male","Work","Texas","TX"));
        add(new User("Patin Silcock",50,"Male","Friend","Tennessee","TN"));
        add(new User("Merralee Odlin",46,"Female","Family","Illinois","IL"));
        add(new User("Berty Moulder",48,"Male","Family","Ohio","OH"));
        add(new User("Kristyn MacKimmie",50,"Female","Family","Arkansas","AR"));
        add(new User("Aubrey McInteer",26,"Male","Family","Oklahoma","OK"));
        add(new User("Sebastiano McLelland",46,"Male","Family","Texas","TX"));
        add(new User("Belvia Fullegar",44,"Female","Friend","Ohio","OH"));
        add(new User("Carlee Coatts",40,"Female","Work","California","CA"));
        add(new User("Ryley Twinborne",52,"Male","Work","Arizona","AZ"));
        add(new User("Lars Matfin",42,"Male","Work","Virginia","VA"));
        add(new User("Jessey Pepis",38,"Male","Work","Oklahoma","OK"));
        add(new User("Malinde Magson",48,"Female","Work","California","CA"));
        add(new User("Krishna Ridewood",40,"Male","Family","Texas","TX"));
        add(new User("Terrye Doul",44,"Female","Work","Iowa","IA"));
        add(new User("Violet Juza",40,"Female","Family","New York","NY"));
        add(new User("Roobbie Chable",30,"Female","Work","Arizona","AZ"));
        add(new User("Chrysa Dupoy",44,"Female","Work","Texas","TX"));
        add(new User("Maurise Fidgeon",22,"Male","Friend","Florida","FL"));
        add(new User("Geoffry Hyland",42,"Male","Work","District of Columbia","DC"));
        add(new User("Agosto Dugan",52,"Male","Work","Michigan","MI"));
        add(new User("Brinn Boutflour",34,"Female","Family","Texas","TX"));
        add(new User("Boniface Grogan",50,"Male","Work","New York","NY"));
        add(new User("Brandie Pettisall",50,"Female","Friend","Ohio","OH"));
        add(new User("Ellette Hatliff",22,"Female","Work","Mississippi","MS"));
        add(new User("Shadow Kovalski",34,"Male","Friend","Florida","FL"));
        add(new User("Jeane Shippam",22,"Female","Friend","Michigan","MI"));
        add(new User("Doralynne Dudley",50,"Female","Work","Florida","FL"));
        add(new User("Frederica Marvell",36,"Female","Family","New York","NY"));
        add(new User("Shanta Pitkaithly",36,"Female","Work","New York","NY"));
        add(new User("Honoria Honig",26,"Female","Work","Connecticut","CT"));
        add(new User("Riki Fannon",46,"Female","Family","California","CA"));
        add(new User("Neddie Durdan",28,"Male","Friend","Pennsylvania","PA"));
        add(new User("Mathian Madrell",36,"Male","Family","Colorado","CO"));
        add(new User("Cleopatra Stoppe",46,"Female","Friend","Arizona","AZ"));
        add(new User("Lynnell Cornick",40,"Female","Family","Wisconsin","WI"));
        add(new User("Hallsy Tamsett",32,"Male","Friend","Texas","TX"));
        add(new User("Clerkclaude Martinetto",42,"Male","Family","New York","NY"));
        add(new User("Lyell Tranckle",52,"Male","Friend","Georgia","GA"));
        add(new User("Alberik Childrens",26,"Male","Work","Arizona","AZ"));
        add(new User("Carlyn Larraway",38,"Female","Family","Washington","WA"));
        add(new User("Orren Janikowski",26,"Male","Family","Michigan","MI"));
        add(new User("Leda Daud",50,"Female","Friend","Arkansas","AR"));
        add(new User("Herbie Fessions",32,"Male","Work","Arizona","AZ"));
        add(new User("Dorian Klauber",48,"Male","Friend","Pennsylvania","PA"));
        add(new User("Ansley Mangeon",28,"Female","Work","Illinois","IL"));
        add(new User("Franky Cowburn",34,"Female","Friend","Michigan","MI"));
        add(new User("Allayne Barbera",50,"Male","Work","Alabama","AL"));
        add(new User("Trula Bellwood",40,"Female","Friend","Florida","FL"));
        add(new User("Dulcie Zollner",26,"Female","Family","Texas","TX"));
        add(new User("Dacy Cockshtt",26,"Female","Family","Oklahoma","OK"));
        add(new User("Olag Rosenblad",36,"Male","Work","Arizona","AZ"));
        add(new User("Marcella Hemerijk",36,"Female","Family","Oregon","OR"));
        add(new User("Gothart Lythgoe",48,"Male","Work","Colorado","CO"));
        add(new User("Shellysheldon Pennyman",40,"Male","Family","Montana","MT"));
        add(new User("Devonna Mafham",50,"Female","Friend","Texas","TX"));
        add(new User("Aksel Priddle",32,"Male","Work","California","CA"));
        add(new User("Salome Sadlier",26,"Female","Work","Oklahoma","OK"));
        add(new User("Aldous McConville",32,"Male","Work","Texas","TX"));
        add(new User("Sheridan Berzen",26,"Male","Family","California","CA"));
        add(new User("Amabel Mundy",32,"Female","Work","Nebraska","NE"));
        add(new User("Guntar Dahle",30,"Male","Work","Kansas","KS"));
        add(new User("Ignazio Meneyer",44,"Male","Work","North Carolina","NC"));
        add(new User("Georgette Rivel",42,"Female","Friend","Colorado","CO"));
        add(new User("Lorie Brotherhood",38,"Female","Family","California","CA"));
        add(new User("Sarajane Romaines",32,"Female","Work","Florida","FL"));
        add(new User("Emmye Figger",34,"Female","Work","Minnesota","MN"));
        add(new User("Jdavie Ubee",40,"Male","Family","Indiana","IN"));
        add(new User("Kahlil Aynsley",24,"Male","Family","Hawaii","HI"));
        add(new User("Chic Croxley",28,"Male","Family","Missouri","MO"));
        add(new User("Veriee MacCaghan",40,"Female","Work","Illinois","IL"));
        add(new User("Reinaldos Mansion",52,"Male","Friend","District of Columbia","DC"));
        add(new User("Kasper Saddler",32,"Male","Friend","Wisconsin","WI"));
        add(new User("Ilario Bartomieu",26,"Male","Family","Texas","TX"));
        add(new User("Ferrel Shaughnessy",26,"Male","Friend","California","CA"));
        add(new User("Patrizia Francioli",50,"Female","Work","California","CA"));
        add(new User("Laurent Grunson",46,"Male","Friend","Missouri","MO"));
        add(new User("Gill Itzkin",34,"Male","Work","Texas","TX"));
        add(new User("Wilona Zmitrovich",22,"Female","Family","Tennessee","TN"));
        add(new User("Shara Cheales",34,"Female","Work","Colorado","CO"));
        add(new User("Tanny Barosch",38,"Male","Family","Texas","TX"));
        add(new User("Leena Neicho",26,"Female","Work","Missouri","MO"));
        add(new User("Reinald Booker",44,"Male","Family","Texas","TX"));
        add(new User("Wain Knights",44,"Male","Friend","Illinois","IL"));
        add(new User("Valera Kitchenside",26,"Female","Friend","Alabama","AL"));
        add(new User("Rollin Brimblecomb",42,"Male","Family","Alabama","AL"));
        add(new User("Perry Trevascus",46,"Male","Family","Georgia","GA"));
        add(new User("Whittaker Pelchat",42,"Male","Work","Nebraska","NE"));
        add(new User("Pamella Kirrens",34,"Female","Friend","California","CA"));
        add(new User("Hamilton Cottrell",30,"Male","Family","Oklahoma","OK"));
        add(new User("Noland Corkill",24,"Male","Family","Tennessee","TN"));
        add(new User("Riva Shafier",48,"Female","Work","Virginia","VA"));
        add(new User("Terry Fliege",36,"Female","Work","Texas","TX"));
        add(new User("Bealle Frankom",28,"Male","Work","Florida","FL"));
        add(new User("Kimmy Sidery",28,"Female","Family","Texas","TX"));
        add(new User("Jesus Blandford",50,"Male","Work","Iowa","IA"));
        add(new User("Eadmund Grundell",50,"Male","Family","West Virginia","WV"));
        add(new User("Annice Redihalgh",34,"Female","Friend","Indiana","IN"));
        add(new User("Vlad Brikner",28,"Male","Friend","Florida","FL"));
        add(new User("Merry Blei",38,"Male","Friend","North Carolina","NC"));
        add(new User("Kessiah Reubbens",26,"Female","Family","Connecticut","CT"));
        add(new User("Beauregard Vail",26,"Male","Friend","Florida","FL"));
        add(new User("Aveline Grubb",28,"Female","Family","Florida","FL"));
        add(new User("Ariel McCandie",34,"Female","Work","New York","NY"));
        add(new User("Moses Allone",40,"Male","Work","New Mexico","NM"));
        add(new User("Harp Lamburn",50,"Male","Work","Iowa","IA"));
        add(new User("Fons Ottley",28,"Male","Work","Texas","TX"));
        add(new User("Sydney Delea",46,"Female","Friend","Nevada","NV"));
        add(new User("Vilhelmina Flohard",30,"Female","Work","Michigan","MI"));
        add(new User("Abner Vakhrushev",42,"Male","Family","Texas","TX"));
        add(new User("Tim Carvilla",48,"Female","Work","Michigan","MI"));
        add(new User("Fairlie Cumber",36,"Male","Work","Pennsylvania","PA"));
        add(new User("Jeni Asbury",34,"Female","Friend","Tennessee","TN"));
        add(new User("Cherri Dumberell",48,"Female","Work","California","CA"));
        add(new User("Jodie Hucke",24,"Female","Family","Texas","TX"));
        add(new User("Loni Cavie",38,"Female","Friend","Texas","TX"));
        add(new User("Dani D'Agostini",36,"Female","Friend","California","CA"));
        add(new User("Waylen Ricardet",30,"Male","Friend","Oklahoma","OK"));
        add(new User("Zechariah Grint",52,"Male","Work","Florida","FL"));
        add(new User("Lyndsay Bingell",44,"Female","Work","Indiana","IN"));
        add(new User("Anatola Tschersich",32,"Female","Friend","Ohio","OH"));
        add(new User("Wolfie People",22,"Male","Work","California","CA"));
        add(new User("Lyle Mikalski",50,"Male","Work","New Jersey","NJ"));
        add(new User("Andrea Eveling",22,"Male","Family","Alabama","AL"));
        add(new User("Drucill Burkett",48,"Female","Family","Texas","TX"));
        add(new User("Rutherford McKeeman",22,"Male","Work","Missouri","MO"));
        add(new User("Erna Licciardello",22,"Female","Family","South Carolina","SC"));
        add(new User("Arabele Cassie",22,"Female","Family","California","CA"));
        add(new User("Cobbie Tewkesberrie",26,"Male","Friend","Texas","TX"));
        add(new User("Elnore Eschelle",40,"Female","Friend","Virginia","VA"));
        add(new User("Elmore Jeskins",48,"Male","Work","Ohio","OH"));
        add(new User("Marchall Woffenden",50,"Male","Friend","Wisconsin","WI"));
        add(new User("Banky O Sullivan",26,"Male","Family","Indiana","IN"));
        add(new User("Nollie Revell",26,"Male","Friend","Pennsylvania","PA"));
        add(new User("Mamie Peddowe",42,"Female","Friend","California","CA"));
        add(new User("Valenka Cheine",28,"Female","Work","Virginia","VA"));
        add(new User("Jacky Greeves",26,"Female","Friend","California","CA"));
        add(new User("Tiffanie Shildrick",38,"Female","Work","Minnesota","MN"));
        add(new User("Ber Moreing",44,"Male","Work","Florida","FL"));
        add(new User("Fredericka Stillgoe",30,"Female","Work","West Virginia","WV"));
        add(new User("Melonie Fallowfield",44,"Female","Work","California","CA"));
        add(new User("Barbee De Beauchamp",48,"Female","Friend","New York","NY"));
        add(new User("Margy Vian",22,"Female","Family","California","CA"));
        add(new User("Harley Beaushaw",46,"Female","Family","Colorado","CO"));
        add(new User("Cherie McGraith",24,"Female","Work","District of Columbia","DC"));
        add(new User("Sher Sidebotton",26,"Female","Work","Virginia","VA"));
        add(new User("Eleonora Clayden",50,"Female","Friend","Georgia","GA"));
        add(new User("Zak Milton",50,"Male","Work","District of Columbia","DC"));
        add(new User("Shani Vaines",38,"Female","Work","North Carolina","NC"));
        add(new User("Sollie Mitchard",46,"Male","Friend","Alabama","AL"));
        add(new User("Ashli Hartil",24,"Female","Work","California","CA"));
        add(new User("Jefferson Leigh",30,"Male","Work","Nevada","NV"));
        add(new User("Hadria Matts",34,"Female","Family","Texas","TX"));
        add(new User("Gaby Gogarty",32,"Male","Friend","South Dakota","SD"));
        add(new User("Hewett Rizzo",32,"Male","Friend","California","CA"));
        add(new User("Sharl Purchall",36,"Female","Family","Alabama","AL"));
        add(new User("Mela Fforde",42,"Female","Work","District of Columbia","DC"));
        add(new User("Edita Becken",50,"Female","Family","Illinois","IL"));
        add(new User("Myca Rahl",28,"Male","Work","Texas","TX"));
        add(new User("Hetty Grange",36,"Female","Work","West Virginia","WV"));
        add(new User("Jackquelin Corkhill",22,"Female","Friend","Kentucky","KY"));
        add(new User("Feliza Redholes",42,"Female","Friend","Colorado","CO"));
        add(new User("Cchaddie Pollett",50,"Male","Family","Montana","MT"));
        add(new User("Johnnie Willoughley",34,"Male","Family","Tennessee","TN"));
        add(new User("Avram Ivanov",50,"Male","Friend","California","CA"));
        add(new User("Danny Talby",34,"Female","Work","Minnesota","MN"));
        add(new User("Livy Gorler",46,"Female","Family","California","CA"));
        add(new User("Emlynne Songust",32,"Female","Friend","Utah","UT"));
        add(new User("Reg Anfosso",30,"Male","Family","Texas","TX"));
        add(new User("Cati Adamovicz",26,"Female","Family","Washington","WA"));
        add(new User("Guendolen Dorken",46,"Female","Work","Kentucky","KY"));
        add(new User("Koral Ringham",36,"Female","Work","Kentucky","KY"));
        add(new User("Debee Suero",22,"Female","Friend","New York","NY"));
        add(new User("Vikky Culshew",48,"Female","Friend","Texas","TX"));
        add(new User("Harmonia Weeke",40,"Female","Family","Alabama","AL"));
        add(new User("Alvie Wrate",44,"Male","Family","Nevada","NV"));
        add(new User("Barris Friary",32,"Male","Family","Oklahoma","OK"));
        add(new User("Shaine O'Neill",24,"Male","Friend","Florida","FL"));
        add(new User("Zulema Joskowitz",28,"Female","Work","Connecticut","CT"));
        add(new User("Dolorita Coggan",48,"Female","Family","Oklahoma","OK"));
        add(new User("Portie Dollin",42,"Male","Family","Pennsylvania","PA"));
        add(new User("Gerrard Stentiford",30,"Male","Friend","Texas","TX"));
        add(new User("Leilah Burborough",40,"Female","Work","Georgia","GA"));
        add(new User("Torry O'Growgane",34,"Male","Work","Wisconsin","WI"));
        add(new User("Fanchette Cumpton",34,"Female","Family","Hawaii","HI"));
        add(new User("Clarita Gillings",28,"Female","Work","Texas","TX"));
        add(new User("Thorvald Marval",46,"Male","Friend","Nevada","NV"));
        add(new User("Kelbee Govett",30,"Male","Family","Texas","TX"));
        add(new User("Demott Iveans",32,"Male","Family","Virginia","VA"));
        add(new User("Muffin Whorlton",50,"Male","Friend","Pennsylvania","PA"));
        add(new User("Curtis O' Bee",42,"Male","Family","District of Columbia","DC"));
        add(new User("Artemas Zanelli",38,"Male","Friend","New Jersey","NJ"));
        add(new User("Bartholomeo Alpes",48,"Male","Family","Missouri","MO"));
        add(new User("Emilio McQuode",48,"Male","Family","Indiana","IN"));
        add(new User("Duff Kirwan",40,"Male","Friend","Oklahoma","OK"));
        add(new User("Eb Shrawley",38,"Male","Family","Massachusetts","MA"));
        add(new User("Cal Titcom",50,"Male","Friend","Arizona","AZ"));
        add(new User("Waylin Porch",36,"Male","Work","Nebraska","NE"));
        add(new User("Ruggiero Morcom",42,"Male","Friend","Texas","TX"));
        add(new User("Stillmann Sleight",50,"Male","Work","New Mexico","NM"));
        add(new User("Enos Etherington",44,"Male","Work","California","CA"));
        add(new User("Junia Stile",38,"Female","Friend","New York","NY"));
        add(new User("Bald Deam",40,"Male","Family","California","CA"));
        add(new User("Carola Godfree",34,"Female","Friend","Colorado","CO"));
        add(new User("Gillian Asser",44,"Female","Work","Kansas","KS"));
        add(new User("Moyra Forrestill",44,"Female","Work","Missouri","MO"));
        add(new User("Stephi Maccrie",46,"Female","Friend","California","CA"));
        add(new User("Samuel Janota",40,"Male","Family","Georgia","GA"));
        add(new User("Zach Linzey",30,"Male","Work","Arizona","AZ"));
        add(new User("Weston Tuppeny",36,"Male","Work","Hawaii","HI"));
        add(new User("Jenelle Lucian",46,"Female","Friend","Texas","TX"));
        add(new User("Willem Giggie",48,"Male","Work","Texas","TX"));
        add(new User("Gavrielle Curryer",28,"Female","Family","Virginia","VA"));
        add(new User("Rodrigo Bustin",34,"Male","Friend","New Jersey","NJ"));
        add(new User("Lionello Ary",42,"Male","Friend","Louisiana","LA"));
        add(new User("Gusty Auchterlony",32,"Female","Friend","Tennessee","TN"));
        add(new User("Wynny Nelle",46,"Female","Work","Georgia","GA"));
        add(new User("Ailsun Priddle",46,"Female","Friend","Texas","TX"));
        add(new User("Kristy Cuttings",38,"Female","Friend","Missouri","MO"));
        add(new User("Birch Lindermann",22,"Male","Friend","Tennessee","TN"));
        add(new User("Andrus Macak",24,"Male","Family","Massachusetts","MA"));
        add(new User("Adorne Berzins",32,"Female","Friend","Alabama","AL"));
        add(new User("Milty Russel",34,"Male","Family","District of Columbia","DC"));
        add(new User("Palmer Giottini",42,"Male","Family","Minnesota","MN"));
        add(new User("Putnem Forrington",46,"Male","Friend","Georgia","GA"));
        add(new User("Sandro Loverock",50,"Male","Friend","New York","NY"));
        add(new User("Carmencita Lighten",52,"Female","Family","Illinois","IL"));
        add(new User("Inglebert Kennagh",48,"Male","Work","Iowa","IA"));
        add(new User("Ring Foxton",24,"Male","Work","Louisiana","LA"));
        add(new User("Becca Muirhead",24,"Female","Work","New York","NY"));
        add(new User("Klement Hayden",24,"Male","Work","New Jersey","NJ"));
        add(new User("Udell Maunder",34,"Male","Work","North Carolina","NC"));
        add(new User("Cheslie Aulton",42,"Female","Work","Florida","FL"));
        add(new User("Bili Eadie",30,"Female","Family","Delaware","DE"));
        add(new User("Betteann Pigrome",44,"Female","Family","Minnesota","MN"));
        add(new User("Forrester Janicijevic",48,"Male","Work","Kansas","KS"));
        add(new User("Temp Emes",40,"Male","Work","District of Columbia","DC"));
        add(new User("Cecilio McClounan",28,"Male","Work","Louisiana","LA"));
        add(new User("Domenico Baselio",52,"Male","Family","Indiana","IN"));
        add(new User("Rey Giacaponi",34,"Male","Friend","Alabama","AL"));
        add(new User("Griff Cruz",26,"Male","Work","California","CA"));
        add(new User("Victor Dealtry",50,"Male","Friend","Virginia","VA"));
        add(new User("Miltie Paszek",28,"Male","Family","California","CA"));
        add(new User("Arlena Ivashkin",26,"Female","Family","Illinois","IL"));
        add(new User("Ive Bisatt",22,"Male","Family","Kentucky","KY"));
        add(new User("Katharina Mussett",28,"Female","Work","Florida","FL"));
        add(new User("Alexandr Rubery",34,"Male","Work","California","CA"));
        add(new User("Fancy Morson",34,"Female","Friend","Florida","FL"));
        add(new User("Pennie O'Cassidy",40,"Male","Friend","Idaho","ID"));
        add(new User("Erinn Lope",40,"Female","Work","California","CA"));
        add(new User("Maridel Durrad",26,"Female","Work","Kentucky","KY"));
        add(new User("Andrey Staite",46,"Male","Work","Illinois","IL"));
        add(new User("Hesther Rennles",32,"Female","Friend","New York","NY"));
        add(new User("Dian Pomfrey",44,"Female","Family","Florida","FL"));
        add(new User("Samaria Rodder",24,"Female","Friend","Massachusetts","MA"));
        add(new User("Geno Sebborn",50,"Male","Work","California","CA"));
        add(new User("Andonis Comiam",46,"Male","Friend","Ohio","OH"));
        add(new User("Dell Rennicks",48,"Female","Work","Michigan","MI"));
        add(new User("Benny Fassbindler",26,"Male","Friend","California","CA"));
        add(new User("Jermain Roskrug",34,"Male","Family","Washington","WA"));
        add(new User("Gavin Ballintime",34,"Male","Work","Florida","FL"));
        add(new User("Madelon Mettericke",52,"Female","Work","California","CA"));
        add(new User("Penny Fransinelli",30,"Female","Family","California","CA"));
        add(new User("Klara Troctor",30,"Female","Friend","Alabama","AL"));
        add(new User("Jeanette Marion",48,"Female","Friend","Indiana","IN"));
        add(new User("Judie Ambrois",42,"Female","Friend","Washington","WA"));
        add(new User("Dori Salle",48,"Female","Family","Florida","FL"));
        add(new User("Joyce Quadling",42,"Female","Work","Texas","TX"));
        add(new User("Cullen Henke",36,"Male","Work","Kansas","KS"));
        add(new User("L;urette Bransom",40,"Female","Friend","Texas","TX"));
        add(new User("Joseito Kunz",30,"Male","Work","California","CA"));
        add(new User("Alaster Beatson",34,"Male","Work","Florida","FL"));
        add(new User("Ingaberg Stanmore",34,"Female","Family","Georgia","GA"));
        add(new User("Jacklyn Belhomme",34,"Female","Work","Arizona","AZ"));
        add(new User("Sean Jain",36,"Male","Family","Texas","TX"));
        add(new User("Arturo Vasenin",42,"Male","Friend","Georgia","GA"));
        add(new User("Budd Soonhouse",30,"Male","Family","District of Columbia","DC"));
        add(new User("Ignatius Rought",48,"Male","Friend","California","CA"));
        add(new User("Delainey Hutt",26,"Male","Work","Pennsylvania","PA"));
        add(new User("Ned Van Cassel",48,"Male","Family","Indiana","IN"));
        add(new User("Hobey Wederell",26,"Male","Family","North Carolina","NC"));
        add(new User("Justis Giacoboni",22,"Male","Work","Texas","TX"));
        add(new User("Dom Highway",26,"Male","Friend","California","CA"));
        add(new User("Gael Possel",26,"Male","Work","Alaska","AK"));
        add(new User("Doug Skune",40,"Male","Family","Arizona","AZ"));
        add(new User("Kerwinn Abramski",34,"Male","Work","West Virginia","WV"));
        add(new User("Larina Malt",28,"Female","Friend","California","CA"));
        add(new User("Emmie Chavez",24,"Female","Family","Florida","FL"));
        add(new User("Karine Houlahan",40,"Female","Work","Ohio","OH"));
        add(new User("Alex Wych",44,"Male","Family","Arizona","AZ"));
        add(new User("Mariellen Cellone",26,"Female","Family","Colorado","CO"));
        add(new User("Bendite Dummett",38,"Female","Friend","Florida","FL"));
        add(new User("Brice Mullally",30,"Male","Family","New York","NY"));
        add(new User("Coralie Colliss",32,"Female","Family","California","CA"));
        add(new User("Zacharia Di Biagi",42,"Male","Work","Michigan","MI"));
        add(new User("Seana Hallaways",26,"Female","Friend","Minnesota","MN"));
        add(new User("Urbanus Simnett",44,"Male","Family","Minnesota","MN"));
        add(new User("Kellia McIntee",28,"Female","Work","Virginia","VA"));
        add(new User("Violette Northam",46,"Female","Friend","Texas","TX"));
        add(new User("Janna Sutherby",24,"Female","Work","Texas","TX"));
        add(new User("Frederick Brisson",40,"Male","Work","Wisconsin","WI"));
        add(new User("Glynda Larderot",44,"Female","Family","Florida","FL"));
        add(new User("Emmy Kitchenham",46,"Female","Work","Texas","TX"));
        add(new User("Wang Mackney",24,"Male","Family","Indiana","IN"));
        add(new User("Randee Cutajar",40,"Female","Friend","Montana","MT"));
        add(new User("Larissa Langfat",50,"Female","Work","Kentucky","KY"));
        add(new User("Konstance Carluccio",52,"Female","Friend","Virginia","VA"));
        add(new User("Kathi Spring",26,"Female","Work","Colorado","CO"));
        add(new User("Keen Wasmuth",48,"Male","Family","Iowa","IA"));
        add(new User("Phaedra Shepherdson",48,"Female","Friend","New York","NY"));
        add(new User("Theda Gemson",48,"Female","Family","Connecticut","CT"));
        add(new User("Jude Pantone",24,"Male","Family","Texas","TX"));
        add(new User("Cristie Epperson",40,"Female","Family","Louisiana","LA"));
        add(new User("Angel Marques",48,"Male","Work","Pennsylvania","PA"));
        add(new User("Brade Eayrs",42,"Male","Friend","Illinois","IL"));
        add(new User("Yvor Vanderplas",48,"Male","Work","Texas","TX"));
        add(new User("Weber MacAllen",32,"Male","Friend","Texas","TX"));
        add(new User("Efren Sare",34,"Male","Friend","Massachusetts","MA"));
    }};

    public static ArrayList<User> getAllUsers(){
        return new ArrayList<>(users);
    }

    public static ArrayList<String> getUniqueStatesList(){
        ArrayList<String> stateList = new ArrayList<>();
        for(User user: getAllUsers()){
            if( !stateList.contains( user.state ) ){
                stateList.add( user.state );
            }
        }
        return stateList;
    }

    public static ArrayList<User> getFilteredList(String state,
                                                  boolean sortAgeAscEnabled,
                                                  boolean sortNameAscEnabled,
                                                  boolean sortStateAscEnabled,
                                                  boolean sortAgeDscEnabled,
                                                  boolean sortNameDscEnabled,
                                                  boolean sortStateDscEnabled )
    {
        ArrayList<User> filteredList;
        ArrayList<User> userArrayList = getAllUsers();
        ArrayList<User> sortFilteredList = checkSortFlags( userArrayList, sortAgeAscEnabled, sortNameAscEnabled, sortStateAscEnabled, sortAgeDscEnabled, sortNameDscEnabled, sortStateDscEnabled );
        if( !state.isEmpty() )
        {
            filteredList = getStateFiltered( sortFilteredList, state );
        }
        else{
            filteredList = sortFilteredList;
        }
        return filteredList;
    }

    private static ArrayList<User> getStateFiltered( ArrayList<User> userArrayList, String state ) {
        ArrayList<User> filteredList = new ArrayList<User>();
        for( User user : userArrayList ){
            if( user.state.contains(state) ){
                filteredList.add( user );
            }
        }
        return filteredList;
    }


    private static ArrayList<User> checkSortFlags( ArrayList<User> userArrayList,
                                                  boolean sortAgeAscEnabled,
                                                  boolean sortNameAscEnabled,
                                                  boolean sortStateAscEnabled,
                                                  boolean sortAgeDscEnabled,
                                                  boolean sortNameDscEnabled,
                                                  boolean sortStateDscEnabled )
    {
        ArrayList<User> sortedList = userArrayList;
        if(sortAgeAscEnabled){
            sortedList = getAgeAscSortedList( userArrayList );
        }
        else if(sortNameAscEnabled){
            sortedList = getNameAscSortedList( userArrayList );
        }
        else if(sortStateAscEnabled){
            sortedList = getStateAscSortedList( userArrayList );
        }
        else if(sortAgeDscEnabled){
            sortedList = getAgeDscSortedList( userArrayList );
        }
        else if(sortNameDscEnabled){
            sortedList = getNameDscSortedList( userArrayList );
        }
        else if(sortStateDscEnabled){
            sortedList = getStateDscSortedList( userArrayList );
        }
        return sortedList;
    }

    public static ArrayList<User> getAgeAscSortedList( ArrayList<User> userArrayList )
    {
        userArrayList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare( o1.age, o2.age );
            }
        });
        return userArrayList;
    }

    public static ArrayList<User> getAgeDscSortedList( ArrayList<User> userArrayList )
    {
        userArrayList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare( o2.age, o1.age );
            }
        });
        return userArrayList;
    }

    public static ArrayList<User> getStateAscSortedList( ArrayList<User> userArrayList )
    {
        userArrayList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.state.compareTo( o2.state );
            }
        });
        return userArrayList;
    }

    public static ArrayList<User> getStateDscSortedList( ArrayList<User> userArrayList )
    {
        userArrayList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.state.compareTo( o1.state );
            }
        });
        return userArrayList;
    }

    public static ArrayList<User> getNameAscSortedList( ArrayList<User> userArrayList )
    {
        userArrayList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo( o2.name );
            }
        });
        return userArrayList;
    }

    public static ArrayList<User> getNameDscSortedList( ArrayList<User> userArrayList )
    {
        userArrayList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.name.compareTo( o1.name );
            }
        });
        return userArrayList;
    }

    public static ArrayList<String> getStaticSortList(){
        ArrayList<String> sortList = new ArrayList<>();
        sortList.add("Age");
        sortList.add("Name");
        sortList.add("State");
        return sortList;
    }

    public static class User implements Serializable {
        public String name,gender,group,state,state_abv;
        public int age;

        public User(String name, int age, String gender, String group, String state, String state_abv) {
            this.name = name;
            this.gender = gender;
            this.group = group;
            this.state = state;
            this.state_abv = state_abv;
            this.age = age;
        }
    }
}
