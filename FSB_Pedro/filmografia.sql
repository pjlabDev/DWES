-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-01-2020 a las 08:41:49
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `filmografia`
--
CREATE DATABASE IF NOT EXISTS `filmografia` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `filmografia`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
CREATE TABLE IF NOT EXISTS `pelicula` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `director` varchar(20) DEFAULT NULL,
  `titulo` varchar(20) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `foto` longblob,
  `descripcion` longtext CHARACTER SET utf8,
  `calificacion` double(5,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` VALUES(1, 'Alex Pina', 'La Casa de Papel', '2019-12-18', 0x68747470733a2f2f696d61676573372e616c706861636f646572732e636f6d2f3931332f7468756d622d313932302d3931333339322e6a7067, '‘La casa de papel‘ cuenta la historia de un atraco perfecto, el más grande y sofisticado de la historia, en la Fábrica de Moneda y Timbre. Quien idea este plan es El Profesor, lleva años diseñando hasta el más mínimo detalle y nada tiene que fallar. Para ello, recluta a siete personas muy diferentes, pero que tienen algo en común: no tienen nada que perder.  Tokio es una joven atracadora buscada por la policía, tras un atraco en el que fallecieron tres personas: su novio y dos de los guardias de seguridad. Berlín asume el papel de cabecilla, Moscú es el experto en perforaciones, Río es un brillante informático, Nairobi es una experta falsificadora, Denver es el hijo de Moscú y, como siempre, falta la fuerza bruta: Helsinki y Oslo.  La banda planea cada paso durante cinco meses en una finca apartada, valoran todos los inconvenientes, todas las posibilidades y cuando llega el momento, se introducen en la Fábrica Nacional de Moneda y Timbre y permanecen encerrados durante once días, con 67 rehenes.  Su objetivo es salir de allí con su propio dinero de curso legal recién impreso sin marcar, y sin causar el menor daño a los rehenes.  Será una tarea difícil, ya que la policía ha acordonado el lugar, y al mando de la operación está la inspectora Murillo, una brillantísima inspectora de policía que intentará darles caza y acabar con el atraco más sonado de la historia.', 7.00);
INSERT INTO `pelicula` VALUES(2, 'Stan lee', 'Amazing Spiderman', '2019-12-17', 0x68747470733a2f2f692e726564642e69742f683735396f643964357a7532312e706e67, 'The Amazing Spider-Man es la historia de Peter Parker (Garfield), un chico de instituto algo marginado que fue abandonado por sus padres cuando era niño, por lo que le criaron su Tío Ben (Sheen) y su Tía May (Field). Como muchos adolescentes, Peter quiere averiguar quién es y cómo llegó a ser la persona que es en la actualidad. Además, Peter encuentra su primer amor de instituto, Gwen Stacy (Stone), y juntos, tendrán que lidiar con el amor, el compromiso, y los secretos. Cuando Peter descubre un misterioso maletín que perteneció a su padre, emprende una búsqueda para llegar al fondo de la desaparición de sus padres, la cual lo llevará directamente a Oscorp y al laboratorio del Dr. Curt Connor (Ifans), el antiguo socio de su padre. Cuando Spider-Man choca con el alter-ego de Connor, El Lagarto, Peter tomará decisiones que afectarán el rumbo de su vida, utilizando sus poderes para forjar su destino y convertirse en un héroe.', 0.00);
INSERT INTO `pelicula` VALUES(3, 'Jon Favreau', 'Iron Man', '2020-01-01', 0x68747470733a2f2f7777772e78747261666f6e646f732e636f6d2f77616c6c7061706572732f7265736f6c7563696f6e65732f31352f69726f6e2d6d616e2d332d6e7565766f5f3139323078313038305f313230302e6a7067, 'Iron Man es la historia del industrial multimillonario y genio inventor Tony Stark (ROBERT DOWNEY JR.). Como consejero delegado de Industrias Stark, el mayor contratista de armamento del Gobierno norteamericano, Tony se ha hecho célebre por proteger durante décadas los intereses norteamericanos en todo el mundo.  El estilo de vida despreocupado de Tony cambia de manera radical cuando su convoy sufre un ataque, tras una prueba de armamento que supervisa personalmente, y se ve convertido en prisionero de un grupo de insurgentes. Herido por un fragmento de metralla, que se aloja cerca de su corazón ya debilitado y pone en peligro su vida, Tony se ve forzado a crear un arma devastadora para Raza (FARAN TAHIR), el misterioso cabecilla de los insurgentes. Tony ignora las exigencias de sus captores y utiliza su intelecto y su ingenio para crear una armadura que lo mantenga con vida y le permita escapar de su cautiverio.  A su regreso a América, Tony debe afrontar la realidad de su pasado y decide emprender un nuevo rumbo con Industrias Stark. A pesar de la resistencia de Obadiah Stane (JEFF BRIDGES), su mano derecha y ejecutivo principal de la compañía, que ha tomado las riendas del negocio en su ausencia, Tony se pasa día y noche en su taller, perfeccionando y puliendo una armadura que le otorgue fuerza sobrehumana y protección física.  Con la ayuda de su asistente de toda la vida, Pepper Potts (GWYNETH PALTROW), y su enlace militar de confianza, James Rhodes, o \"Rhodey\" (TERRENCE HOWARD), Tony descubre un siniestro complot con ramificaciones globales. Enfundándose su imponente armadura roja y dorada, Tony se compromete a proteger el mundo y corregir sus injusticias como su nuevo alter ego, Iron Man.', 7.67);
INSERT INTO `pelicula` VALUES(4, 'Todd Philips', 'Joker', '2020-01-08', 0x68747470733a2f2f73312e317a6f6f6d2e6d652f626967372f3538372f4a6f6b65725f6865726f5f436c6f736575705f4a6f617175696e5f50686f656e69785f4a6f6b65725f323031395f3537303238365f3139323078313038302e6a7067, 'Arthur Fleck es un payaso con una extraña enfermedad mental. Responsable del cuidado de su madre enferma, sueña con su propio espectáculo de stand up comedy. La situación no es favorable. Tanto su condición mental como su oficio lo hacen blanco frecuente de agresiones en ciudad Gótica, ciudad sumida en una profunda tensión social.  Fleck es atacado en el metro por tres jóvenes ebrios, pero esta vez, decide ser el victimario. El triple asesinato, divulgado en los medios de comunicación, genera la simpatía de los ciudadanos. Al ver cómo el caos se precipita, el político Thomas Wayne, venerado por la madre de Fleck, anuncia su candidatura a alcalde. Pero ahora que el subestimado y mentalmente enfermo Arthur Fleck ha ganado popularidad, su vida y la de ciudad Gótica dan un giro radical.', 7.50);
INSERT INTO `pelicula` VALUES(5, 'Scott Derrickson', 'Doctor Strange', '2016-06-24', 0x68747470733a2f2f696d616765732d322e7775616b692e74762f73797374656d2f73686f74732f36393137312f6f726967696e616c2f646f63746f722d65787472616e6f2d7072652d6f726465722d313438303037343438382e6a706567, 'El doctor Stephen Strange (Benedict Cumberbatch) es un reputado neurocirujano de Nueva York. Todo lo que tiene de brillante y talentoso, lo tiene también de arrogante y vanidoso. Tras sufrir un terrible accidente de coche, sus manos quedan dañadas, cosa que arruina por completo su carrera. Después de varias intervenciones quirúrgicas de su colega, el doctor Nicodemus West (Michael Stuhlbarg), las manos de Stephen Strange consiguen recuperar su movilidad parcial, pero no la suficiente pericia como para volver a operar.   Después de estos dramáticos sucesos, y de tener que abandonar definitivamente su profesión, Stephen Strange decide realizar un viaje de sanación al Himalaya que le cambiará la vida. Alejándose de la medicina tradicional, buscará una nueva cura para su lesión. Será entonces cuando conozca a El Anciano (Tilda Swinton), quien le enseñará que el mundo en el que vive es una realidad entre muchas. Descubrirá así un mundo oculto de dimensiones mágicas, y durante su entrenamiento con el maestro místico se revelarán sus poderes psíquicos, como la telepatía, la proyección astral o el teletransporte, que utilizará para combatir al mal.', 0.00);
INSERT INTO `pelicula` VALUES(6, 'Zack Snyder', 'El hombre de acero', '2018-07-12', 0x68747470733a2f2f6d69726f2e6d656469756d2e636f6d2f6d61782f333834302f312a306c565f35774e4e48774f6b71376f786b4f4c496e412e6a706567, 'Protagonizada por Henry Cavill (Immortals, la serie de televisión Los Tudor) en el papel de Clark Kent/Superman, bajo la dirección de Zack Snyder (300, Watchmen).  La película también está protagonizada por la tres veces nominada al Oscar® Amy Adams (The Fighter) como la periodista del Daily Planet Lois Lane, y por el nominado al Oscar® Laurence Fishburne (Tina) como su redactor jefe, Perry White. En el papel de los padres adoptivos de Clark Kent, Martha y Jonathan Kent, están la nominada al Oscar® Diane Lane (Infiel) y el ganador del Premio de la Academia Kevin Costner (Bailando con lobos).  Un chico descubre que tiene poderes extraordinarios y que no pertenece a la Tierra. A partir de ese momento, se embarca en un viaje para descubrir de dónde procede y para qué fue enviado a la Tierra. El héroe que se encuentra en su interior debe salir a relucir si pretende salvar al mundo de su total destrucción y convertirse en símbolo de esperanza para toda la humanidad.  Frente al super héroe están los otros dos supervivientes del Planeta Krypton, el malvado General Zod, representado por el nominado al Oscar® Michael Shannon (Revolutionary Road), y Faora, la diabólica socia de Zod, interpretada por Antje Traue. También procedentes de Krypton, de donde Superman es nativo, están Lara Lor-Van, la madre de Superman, interpretada por Ayelet Zurer (Ángeles y demonios), y el padre de Superman, Jor-El, interpretado por el ganador del Premio de la Academia Russell Crowe (Gladiator).  Redondeando el reparto están Harry Lennix como el General Swanwick del ejército de los Estados Unidos, así como Christopher Meloni como el Coronel Hardy y Richard Schiff como el Dr. Emil Hamilton.', 9.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelusua`
--

DROP TABLE IF EXISTS `pelusua`;
CREATE TABLE IF NOT EXISTS `pelusua` (
  `IDPelicula` int(11) DEFAULT NULL,
  `IDUsuario` int(11) DEFAULT NULL,
  `Calificacion` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pelusua`
--

INSERT INTO `pelusua` VALUES(1, 4, 10);
INSERT INTO `pelusua` VALUES(3, 1, 10);
INSERT INTO `pelusua` VALUES(1, 1, 4);
INSERT INTO `pelusua` VALUES(5, 1, 4);
INSERT INTO `pelusua` VALUES(3, 3, 10);
INSERT INTO `pelusua` VALUES(3, 5, 3);
INSERT INTO `pelusua` VALUES(6, 1, 9);
INSERT INTO `pelusua` VALUES(4, 1, 10);
INSERT INTO `pelusua` VALUES(4, 5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `apellidos` varchar(20) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` VALUES(1, 'Pedro', 'Perez', 'Pedraso', 'pedro');
INSERT INTO `usuario` VALUES(2, 'James', 'Gonzalez', 'James23', 'james');
INSERT INTO `usuario` VALUES(3, 'Stan', 'Lee', 'Stan55', 'stan');
INSERT INTO `usuario` VALUES(4, 'Manolo', 'Lama', 'admin', 'admin');
INSERT INTO `usuario` VALUES(5, 'Agustin', 'Fernandez', 'Agus', 'agus');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
