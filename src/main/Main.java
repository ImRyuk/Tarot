package main;


import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cards.*;
import view.CardCollectionMenu;


public class Main {

  public static void main(String[] args) throws IOException {
	  ArrayListCard cards = loadCards();

	  showWindow(cards);
	 
	    
//	  Serialize(cards, "Bonsoir");
//	  
//	  ArrayListCard cards2 = new ArrayListCard();
//      cards2 = Deserialize("Bonjour");	
//      System.out.println(cards2.size);
    }
  
  public static void showWindow(ArrayListCard cards) {
	  JFrame f = new JFrame("frame");
      
      //create a panel 
      JPanel p =new JPanel(); 
      
      CardCollectionMenu cardcollection = new CardCollectionMenu(p, cards);
      
      //Render the Card Collection Menu
      cardcollection.render();
 
      f.add(p); 
        
      //set the size of frame 
      f.setSize(800,1000); 
         
      f.show(); 
  }
  
  public static void Serialize(ArrayListCard cards, String fileName) {
	  try
      {
          FileOutputStream fos = new FileOutputStream("files/serialization/" + fileName);
          ObjectOutputStream oos = new ObjectOutputStream(fos);
          oos.writeObject(cards);
          oos.close();
          fos.close();
      } 
	      catch (IOException ioe) 
	      {
	          ioe.printStackTrace();
	      }
	}
  
  public static ArrayListCard Deserialize(String fileName) {
	  ArrayListCard cards = new ArrayListCard();
	  try
      {
          FileInputStream fis = new FileInputStream("files/serialization/" + fileName);
          ObjectInputStream ois = new ObjectInputStream(fis);

          cards = (ArrayListCard) ois.readObject();

          ois.close();
          fis.close();
      } 
      catch (IOException ioe) 
      {
          ioe.printStackTrace();
          return null;
      } 
      catch (ClassNotFoundException c) 
      {
          System.out.println("Class not found");
          c.printStackTrace();
          return null;
      }
	  return cards;
	  
  }
  
  public static ArrayListCard loadCards() {
	  
	  ArrayListCard cards = new ArrayListCard();
	  Card mat = new Card(0, "Le Mat", 
			  "Un homme avance vers l'horizon, une canne à la main. Il porte sur son épaule droite une besace de couleur jaune. Il est vêtu tel un pèlerin qui entamerait un voyage vers un chemin encore incertain.\r\n"
	  		+ "\r\n"
	  		+ "Derrière lui, un animal semble s'accrocher à lui. Qu'il s'agisse d'un chien ou d'un chat, le personnage n'y accorde aucune importance et continue son chemin en dépit des obstacles qui se présentent à lui. Il semble se diriger vers un chemin incertain.\r\n"
	  		+ "\r\n"
	  		+ "Seule arcane majeure dans le tarot de Marseille à ne pas disposer d'un numéro, le Mat est souvent placé au début du cycle. La carte représenterait un personnage encore immature qui entamerait un chemin vers la connaissance et la sagesse.",
	  		"Vous êtes dans une situation où vous devez faire un choix. Même si les conséquences semblent encore un peu floues dans votre tête, vous êtes décidé à aller de l'avant et cela pourrait vous conduire à atteindre votre objectif. Certains éléments ou certaines personnes de votre entourage tendent toutefois à vous dissuader d'agir mais la réussite semble accompagner votre démarche.",
	  		"Faites toutefois attention aux imprévus car le personnage décrit par le Mat montre un comportement impulsif. Essayez d'être attentif aux obstacles qui se présenteront sur votre chemin car la nonchalance et l'imprudence peuvent conduire aux pires situations. Tâchez de rester cohérent dans vos décisions afin de gagner en maturité.",
	  		"Le Mat indique que vous détenez la solution de votre problème mais que vous devez vous faire comprendre. Si l'action à mener paraît floue et quelque peu confuse, faites confiance à votre intuition et allez de l'avant. Un conseil, pour arriver à un résultat à la hauteur de votre espérance, comptez sur votre détermination et gardez en tête votre objectif.",
	  		"Le Mat vous indique un nouveau départ. Si vous êtes suffisamment déterminé pour atteindre votre objectif, c'est-à-dire en mesure de faire face aux différents obstacles qui se présentent à vous, vous devrez parvenir à votre but . Pour cela, ayez confiance en vous, et ne perdez pas espoir. Si votre avenir semble flou, c'est que la situation que vous envisagez est nouvelle. Cela n'est pas synonyme d'échec ou d'insuccès. Soyez vigilant et faites preuve de prudence, prenez garde à votre libre arbitre, tant de chemins sont encore ouverts.",
	  		"Vous allez démarrer quelque chose de nouveau, qui semble encore un peu flou dans votre tête. Vous faites face à des imprévus et vous ne savez pas quel chemin choisir. Le Mat laisse planer un doute sur la réussite de votre situation. Tâchez de faire preuve de pragmatisme et gardez en vue votre objectif. Vous disposez de grandes qualités qui doivent vous permettre de dissiper les aléas, les incertitudes, afin de vous conduire vers une situation plus confortable.",
	  		new File("files/img/cards/1-bateleur.jpg"));
	  Card bateleur = new Card(1, "Le Bateleur",
			  "Le Bateleur représente un personnage jeune qui se tient debout en face d'une table sur laquelle sont disposés différents objets. Vêtu de bleu, de rouge et de jaune, le personnage regarde sur sa droite et semble serein. Son chapeau forme un 8, symbole de l'infini, et indique une certaine forme de liberté d'actions.\r\n"
			  + "\r\n"
			  + "Dans sa main gauche, le personnage tient une baguette qui fait référence à sa maîtrise des éléments matériels. Référence qui est rappelée par les quelques objets disposés en face de lui : des pièces de monnaie, un gobelet, des dés et un couteau.\r\n"
			  + "\r\n"
			  + "Le Bateleur est la première carte du tarot de Marseille. Elle possède le numéro 1 et se place au début du cycle.",
			  "Le Bateleur représente le savoir faire, la jeunesse et l'innovation. Vous êtes sur le point de démarrer quelque chose de nouveau et votre enthousiasme semble être une qualité essentielle dans la réussite de votre projet. Votre compétence vous confère une certaine maîtrise de la situation mais sans effort, tout projet est vain. Vous semblez rempli de joie à l'idée de vous engager dans cette nouvelle situation.",
			  "En revanche, vous devez garder à l'esprit que le savoir faire ne sert à rien lorsqu'il n'est pas structuré de façon organisé. Vous semblez engagé dans un projet sans avoir de vision à moyen terme et quand bien même vous disposez de toutes les compétences pour menez à bien votre projet, celui-ci semble ralenti par un manque d'organisation. Vous accordez trop de temps sur les choses futiles et perdez à l'esprit l'essentiel. Prenez du recul afin de mieux appréhender votre avenir.",
			  "Souvent placé en début d'un cycle conduisant à la sagesse, le Bateleur vous incite à entamer un nouveau chemin. Vous devez redevenir l'acteur de votre propre vie et mettre à profit votre expérience pour démarrer quelque chose de nouveau. Laissez vous guider par votre joie de vivre et aborder l'avenir de façon plus mature. La réussite se trouvera peut être au rendez-vous.",
			  "Le Bateleur indique un nouveau départ. Que ce soit sur le plan sentimental ou professionnel, vous allez prochainement entamer un nouveau départ. Pour multiplier les chances de réussite de ce nouveau projet, vous devrez user de votre intelligence et de votre savoir faire afin d'entreprendre avec succès cette nouvelle situation.",
			  "Le Bateleur vous permet d'envisager sereinement un nouveau départ. Vous devrez user de votre expérience et de la maîtrise de vos compétences pour mener à bien ce projet. N'hésitez pas à aller de l'avant, mais restez vigilent : un projet bien mené est un projet réfléchi. Si vous pensez ne pas avoir le savoir faire pour réussir votre entreprise quelle qu'elle soit, ne perdez pas espoir, persévérez et gagnez en compétence.",
			  new File("files/img/cards/0-fou.jpg"));
	  Card papesse = new Card(1, "La Papesse",
			  "La Papesse est la 2ème arcane majeure du tarot de Marseille. Son chiffre 2 symbolise tout ce qui a trait au monde féminin. Elle représente une femme d'un certain âge qui est assise avec un livre sur les genoux.\r\n"
			  + "\r\n"
			  + "Vêtue d'une grande cape bleue sous laquelle on aperçoit une robe rouge, la femme paraît reposée et d'une grande maturité. Elle tient un livre sur ses genoux qu'elle ne regarde pas. Il s'agit là d'un des points clés de la carte. Le livre représente la connaissance et son regard laisse entendre qu'elle en détient la clé. On peut distinguer sur sa robe rouge deux bandes de couleur jaune que l'on peut assimiler à une serrure. Celle-ci conduirait à la connaissance et le devoir de chacun serait d'en trouver la clé.",
			  "Vous semblez serein dans l'approche que vous choisissez pour appréhender votre avenir. La Papesse montre une forme de sagesse dans votre attitude qui vous sera utile pour mener à bien votre projet. Laissez-vous guider par votre intuition. La maturité qui émane de la Papesse devrait vous permettre de conduire votre projet avec succès.",
			  "En revanche, la Papesse montre que vous manquez de dynamisme et de conviction dans la réussite de votre projet. Ne vous laissez pas aller à l'oisiveté, et gardez bien en tête votre objectif. Vous réfléchissez trop avant d'agir et vous manquez sans doute de confiance en vous. Réagissez afin de mettre à profit l'ensemble de votre champ de compétences.",
			  "La situation à laquelle vous réfléchissez manque de concret. Vous avez tendance à trop réfléchir à votre état actuel et vous manquez de confiance en l'avenir. La Papesse vous indique un évènement nouveau à venir, qui ne s'est pas encore déclaré. Soyez sensible aux changements qui vont arriver dans votre vie. Votre entourage pourra vous aider à passer à l'action si vous manquez de confiance en vous lorsque la situation se présentera.",
			  "La Papesse met en avant un manque d'évolution dans votre situation. Vous restez enfermé dans une situation qui ne saurait vous convenir. Vous devez vous remettre en question et devenir plus actif. Sur le plan professionnel, vous vous contentez d'une situation qui pourrait évoluer à condition que vous vous en donniez les moyens. Sur le plan sentimental, vous faites preuves d'une certaines sagesse et aborder l'avenir avec calme.",
			  "La Papesse montre que vous pouvez avoir confiance en votre intuition. Vous interprétez avec grande facilité les comportements de votre entourage mais vous manquez de confiance en vous pour avancer dans votre projet de vie. Soyez moins cérébral, et restez concentrer sur des actions concrètes. N'oubliez pas : la Papesse se discrédite trop souvent dans l'oisiveté.",
			  new File("files/img/cards/2-papesse.jpg"));
	  Card imperatrice = new Card(3, "L'impératrice",
			  "L'Impératrice représente une femme assise sur un trône. Elle tient dans sa main gauche un sceptre et dans sa main droite un bouclier représentant un aile aux ailes déployées.\r\n"
			  + "\r\n"
			  + "L'impératrice porte les emblèmes de la royauté son trône la place sur une forme de piédestal. Son attitude lui confère un caractère dominateur et son regard semble grâce et porté vers l'avenir.\r\n"
			  + "\r\n"
			  + "Cette lame contraste avec la Papesse (II) à laquelle elle succède en présentant une femme d'action qui s'intéresse aux choses concrètes. Si la Papesse semblait bridée dans une phase de gestation, l'impératrice qui lui succède semble plus épanouie et se focalise sur la réalisation concrète d'un projet.\r\n"
			  + "\r\n"
			  + "Son regard semble annoncer la lame suivante: l'Empereur, qu'elle soutient par sa féminité et par sa bienveillance.",
			  "Vous êtes un bon communiquant. A l'aise dans les relations que vous entretenez avec votre entourage, vous gagnez à être connu et votre intellect est rarement remis en question. L'Impératrice montre une prédisposition pour tout ce qui touche à l'organisation et à la mise en oeuvre d'une action. Ayez confiance en vous, vous semblez doué pour conduire un projet.",
			  "En revanche, l'Impératrice dénote une haute estime de vous même. Si par le passé vous avez conduit vos projets avec succès, cela ne veut pas dire que vous êtes à l'abri de l'échec. Il n'y a pas d'équation gagnante pour mener à bien une action et vous devrez vous remettre en question afin de canaliser votre amour propre. Il faut parfois savoir s'incliner pour prendre du recul et appréhender de manière objective une situation donnée.",
			  "Afin de mener à bien votre projet, vous devrez compter sur votre intellect et sur votre force de persuasion. L'Impératrice présente un personnage disposant d'une grande reconnaissance sociale. Celle-ci sera essentielle dans la réalisation de votre action. N'hésitez pas à aller vers les autres pour leur demander de l'aide. Ces derniers sauront vous apporter le soutien nécessaire pour que vous puissiez conduire vos actions vers la réussite.",
			  "L'Impératrice se distingue des autres lames par sa force d'action. Vous allez faire preuve d'une grande souveraineté dans la réalisation de votre projet. Le succès risque d'être au rendez-vous dans la mesure où vous vous cantonner à la phase opérationnel du projet. Vous pouvez avoir confiance dans l'avenir, car vous allez rencontrer de nouvelles personnes, et de nouveaux évènements vont se présenter à vous. Vous serez à même d'y faire face.",
			  "Vous êtes force de proposition et vous faites preuve d'ambition. L'Impératrice montre que vous allez devoir face à une situation nouvelle. Vous devrez aborder cette situation avec pragmatisme et faire appel à toutes vos compétences pour choisir le bon chemin et continuer à avancer dans votre projet de vie. N'hésitez pas à multiplier les contacts, votre appétence pour les relations à autrui vous permet de tirer parti des interactions sociales, et cela devrait être essentiel dans votre quête du succès.",
			  new File("files/img/cards/3-imperatrice.jpg"));
	  Card empereur = new Card (4, "L'empereur",
			  "La lame de l'Empereur porte le numéro 4, qui représente les 4 éléments : la terre, l'eau, le feu et l'air. Elle succède à l'Impératrice, et représente un homme de profil assis sur un trône.\r\n"
			  + "\r\n"
			  + "Il tient un sceptre en or, symbole de l'autorité et du pouvoir. Sa couronne fait penser à un bonnet phrygien. Sur son trône, apparaît un aigle aux ailes déployées. De la même manière que l'Impératrice (III), sont présents les emblèmes de la royauté et du pouvoir.\r\n"
			  + "\r\n"
			  + "Le personnage semble serein et en pleine possession de ses moyens. Son attitude lui confère puissance, fermeté, et autorité. Il croise sa jambe droite par dessus sa jambe gauche pour montrer que son devoir se place au dessus de son affect.\r\n"
			  + "\r\n"
			  + "Le regard droit, l'Empereur représente un personnage ambitieux, qui semble animé par une logique de conquête et de protection.",
			  "L'Empereur indique que vous êtes dans une situation stable. Vous accordez beaucoup d'importances aux conséquences de vos propres actions, et vous avez des projets. Vous faites preuve d'ambition, et cela vous pousse à agir. L'empereur montre que vous êtes aptes à assumer des responsabilités plus importantes, mais pour cela, vous devez vous donner les moyens d'évoluer dans votre environnement social.",
			  "Vous n'avez pas toujours les réponses aux problématiques qui se présentent à vous, et cela vous frustre. L'empereur montre que vous ne cédez jamais et que vous souhaitez toujours aller au bout de ce que vous commencez. Cela peut vous conduire à vous enliser dans une situation complexe et vous avez du mal à en sortir. N'oubliez pas qu'il faut parfois trouver des compromis, afin d'avancer sur des bases plus saines.",
			  "Pour réussir avec succès votre projet de vie, vous allez devoir suivre les traces de l'Empereur. Il vous faudra faire preuve de fermeté et de conviction afin de faire valoir votre personnalité et vos idées. Soyez organisé, et ayez confiance en vos capacités. Ne négligez pas l'influence de votre entourage dans la réalisation de votre projet afin d'être soutenu et conseillé par une figure extérieure.",
			  "L'empereur montre que votre projet se concrétise. L'action que vous avez envisagées pour mener à bien votre projet devrait porter ses fruits et clarifier votre situation. L'empereur apporte de la densité à votre projet et montre que vos choix ont mené à des résultats concrets dont vous récoltés les fruits au quotidien. Des changements devraient se présenter prochainement et de manière concrète dans votre vie.",
			  "L'Empereur vous prédit beaucoup de stabilité dans votre situation à venir. Vous êtes sur le point d'aboutir à une situation d'équilibre dans laquelle les choses sembleront plus simples. Votre ambition et votre motivation vous permettent d'évoluer rapidement vers un point d'équilibre qui pourrait vous satisfaire. Gardez tout de même à l'esprit que la stabilité n'est pas synonyme d'oisiveté et qu'il faut parfois savoir rester humble et modeste afin de garder les pieds sur terre.",
			  new File("files/img/cards/4-empereur.jpg"));
	  Card pape = new Card (5, "Le Pape",
			  "Le Pape porte le numéro 5, symbole du changement. il représente un personnage âgé, aux cheveux et à la barbe blancs. Il porte une tunique bleu et une cape rouge.\r\n"
			  + "\r\n"
			  + "En face de lui, deux disciples sont agenouillés et semblent lui vouer une grande admiration. Il les bénit de sa main droite. Son regard est plus lointain, il semble orienté vers une dimension plus large : l’infini diront certains.\r\n"
			  + "\r\n"
			  + "Il porte sur la tête une tiare à trois étages et tient dans sa main gauche une croix. Ces deux symboles de la papauté renvoient l’image du patriarche, du protecteur.",
			  "Vous êtes une personne prévenante, qui sait prendre soin d’elle et de son entourage. Vous avez en vous une belle lumière qui vous anime au quotidien. Votre vision des choses de la vie est claire et votre esprit est lucide. Votre côté chaleureux vous permet d’être apprécié de vos amis et d’être une bonne personne, avec un grand coeur et des valeurs solides.",
			  "Mais attention ! C’est bien de croire en soit, mais vous ne devez pas aller trop loin dans la confiance aveugle que vous portez à votre personne. Restez humbles et méfiez-vous des mauvais conseils que certaines personnes de votre entourage pourraient vous donner. Restez sur vos gardes, vous risquez dans les prochaines semaines d’être déçu par certaines choses autour de vous.",
			  "Retrouvez votre confiance. Écoutez votre entourage, leurs conseils vont vous permettre de remonter la pente et de vous retrouver vous-même. Vous ressentez fortement ce besoin de lâcher prise, de liberté, de retour à des choses simples. Il est temps de prendre du recul sur les choses. Un séjour à la campagne vous ferait le plus grand bien.",
			  "Vous bénéficiez de la protection du pape. C’est une très bonne chose. Vous devez donc être rassuré face aux questions que vous vous posez actuellement. Vous êtes tourmenté mais le bout du tunnel est proche, vous avancez tranquillement vers un avenir meilleur, sous la protection du Pape, garant de votre bonheur et succès futurs.",
			  "Vous êtes dans un excellent cycle ! Bientôt, le succès vous gagnera. Vos projets vont se réaliser et même aller au-delà de vos espérances. Vous allez pouvoir réaliser vos rêves. En amour, vous allez gagner en confiance et faire de nouvelles rencontres qui vont renforcer vos relations et vous permettre de rester dans une dynamique positive. Le monde est à vous, profitez-en.",
			  new File("files/img/cards/5-pape.jpg"));
	  Card amoureux = new Card (6, "L'Amoureux",
			  "L’Amoureux porte le numéro 6. Il représente 4 personnages : un angelot, un homme et deux femmes.\r\n"
			  + "\r\n"
			  + "La femme située sur la gauche de l’arcane semble plus âgée et pose sa main sur l’épaule droite de l’homme. A sa droite, la femme pose sa main sur son coeur.\r\n"
			  + "\r\n"
			  + "Au dessus de l’homme, un angelot tient un arc dans sa main. Il est entouré d’une vive lumière représentée par les couleurs jaune rouge et bleu. L’angelot représente cupidon et ne sait pas où tirer sa flêche.\r\n"
			  + "\r\n"
			  + "Il semblerait que l’homme soit en phase de faire un choix entre les deux femmes. L’une représenterait la voie profane et l’autre la voie sacrée. Le regard de l’homme semble diriger vers la femme la plus âgée en dépit des gestes d’affection entrepris par la femme située sur la droite. L’Amoureux représente un carrefour. L’individu est arrivé à un moment de sa vie où il doit faire un choix : la raison ou l’amour ?",
			  "Vous êtes perdu. Vous vous retrouvez déboussolé et ne savez plus dans quelle direction aller. Le doute vous habite, depuis plusieurs semaines déjà. Cette situation vous rend triste et vous ne savez plus quoi faire pour en sortir. L’Amoureux est un personnage indécis, incertain, pris entre deux feux et ne sachant quel mode de vie choisir entre ceux qui s’offrent à lui.",
			  "Seulement vous êtes dans un immobilisme qui vous paralyse et vous empêche de choisir entre deux situations. Vous êtes “ni oui ni non”. La peur de choisir vous habite, et vous préférez être dans l’attente plutôt que de prendre une mauvaise décision. Vous êtes passif et tourmenté, vous fuyez des responsabilités qui pourtant vous incombent.",
			  "Vous êtes incapables, depuis plusieurs semaines, de faire un choix. Plusieurs dilemmes sont en face de vous depuis bien longtemps et vous n’arrivez pas à les arbitrer. Méfiez-vous, car dans les prochains jours, une nouvelle donne pourrait vous obliger à faire un choix contre votre gré. Ce choix pourrait s’avérer compliqué à gérer car il va être pris dans la précipitation et dans la contrainte.",
			  "L’Amoureux vous invite à faire un choix. Vous devez cesser de tergiverser sur des situations dans lesquelles vous semblez perdus et impuissant. Prendre la décision d’agir, c’est déjà un premier pas pour se sortir du cercle vicieux de la passivité. Il est temps d’assumer vos responsabilités, quitte à devoir remettre en question certaines choses et vous réorienter dans une direction nouvelle.",
			  "Il faut prendre du recul sur votre vie, essayer de réfléchir sur vous-même. Vous avez du mal à faire des choix, il est temps de reconsidérer l’ordre des choses. Faites un point : quels sont vos objectifs actuels ? Vos envies, vos désirs ? Ce recul vous permettra de repartir du bon pied et de profiter plus pleinement de votre vie en refusant de vous enfermer dans des situations où vous êtes incapable de choisir entre deux voies. Savoir où l’on va permet de ne plus réfléchir sur la route à emprunter.",
			  new File("files/img/cards/6-amoureux.jpg"));
	  Card chariot = new Card (7, "Le Chariot",
			  "Le Chariot représente un homme assis dans un char qui avance tiré par deux chevaux. L’homme a l’air serein et son regard semble orienté vers le lointain.\r\n"
			  + "\r\n"
			  + "Les deux cheveux avancent dans des directions différentes, ce qui semblent matérialiser les différentes possibilités qui s’offrent au personnage. Sous les sabots des chevaux, apparaissent des buissons auxquels ces derniers n’accordent aucune importance. Ils avancent d’un pas décidé, en dépit des obstacles qui se présentent à eux. L’homme ne tient pas les brides des chevaux car c’est un conquérant. Le chemin qu’il prend est symbolisé par son regard et non par le contrôle qu’il a sur ses chevaux.\r\n"
			  + "\r\n"
			  + "Le Chariot est une lame remplie d’espoir. Elle est lumineuse et fait apparaître la dualité entre la Lune (XVIII) et le Soleil (XVIIII). L’ambition affichée par le personnage et les couleurs adoptées rappellent les deux grandes forces présentes dans le début du cycle : l’Impératrice (III) et l’Empereur (IV).",
			  "Vous êtes un fonceur ! Vous aimez être dans l’action, vous ne tenez pas en place. Au travail, vous courez partout et êtes réputé pour être une personnalité stressée. Votre défaut ? Avoir parfois tendance à agir avant de réfléchir... et vous en payez parfois les pots cassés. Le Chariot est aussi un personnage qui aime entreprendre et qui croit en sa chance.",
			  "Malheureusement vous agissez souvent mal. Vous avez un défaut : vous manquez de confiance en vous ou, au contraire, avez une trop grande confiance en vous. Ce déséquilibre a tendance à vous poser des soucis lors de vos relations avec les autres. Vous passez souvent pour quelqu’un d’immature, et vous avez beau vouloir agir bien, vous vous rendez compte que souvent vos actions sont mal perçues.",
			  "Il est temps pour vous d’aller de l’avant. Foncez ! Vos serez récompensé de vos efforts. C’est le moment pour vous de prendre un nouveau départ, de reconsidérer certaines choses et de modifier vos plans. Vous devez tirer partie de votre expérience et vous engager dans de nouvelles choses qui vous correspondent mieux et dans lesquelles vous vous retrouverez plus facilement.",
			  "Vous êtes dans le mouvement. Les choses bougent autour de vous, et devraient continuer à bouger dans les mois qui viennent. Le Chariot vous fait bouger et vous offres des opportunités qui devraient se concrétiser, tout par exemple un déménagement, un nouvel emploi, ou encore une nouvelle relation.",
			  "Vos projets ont du mal à aboutir et vous n’êtes pas forcément dans une situation de réussite avérée. Cependant, votre fougue et votre dynamisme vous permettent de continuer à avancer, d’être toujours positif, et c’est pourquoi vos projets finiront par aboutir. Vous y mettez tout votre coeur, et c’est ce qui fera la différence à l’arrivée. Utilisez ce positivisme et cette force mentale pour avancer toujours plus loin.",
			  new File("files/img/cards/7-chariot.jpg"));
	  Card justice = new Card (8, "La Justice", 
			  "La Justice représente une femme au regard sévère. Assise sur un trône de couleur dorée, la femme semble intransigeante et impartiale. Elle porte une tunique rouge, recouverte d’une cape bleu.\r\n"
			  + "\r\n"
			  + "Elle tient dans sa main droite une épée qui indique qu’elle détient les armes pour sanctionner. Elle se place donc en juge et semble en mesure d’interpréter avec la plus grande des sévérités un conflit.\r\n"
			  + "\r\n"
			  + "Dans sa main gauche, elle tient une balance parfaitement équilibrée. Celle-ci met en avant l’impartialité et la neutralité de la justice, qui sont les deux attributs garant de sa stabilité dans une organisation.",
			  "La Justice est une personnalité très méthodique et consciencieuse. Elle est bien évidemment honnête et aime ce qui est juste et égalitaire. Elle sait faire preuve de diplomatie et aime le compromis. Vous avez une vie carrée et bien organisée, vous aimez l’anticipation et vous êtes heureux comme tout se passe comme prévu.",
			  "Une fâcheuse tendance à la rigidité fait de vous une personnalité parfois dure avec l’entourage. Les choses doivent se dérouler comme vous l’avez prévu, et le moindre imprévu vous paralyse et peut vite vous faire entrer dans un état d’énervement : vous avez besoin de contrôler les choses. Vous êtes lent à changer votre façon de penser et à l’adapter à celle des autres.",
			  "Essayez d’agir avec modération. Calmez vos ardeurs et sachez faire preuve de prudence. Prenez les évènements un à un et gérez-les avec recul et intelligence. Ne cherchez surtout pas à surtout du cadre établi, ça n’est pas la bonne période pour le faire. Pas d’initiatives trop en décalage avec ce que vous faites habituellement. Ne franchissez pas de limites ce mois-ci, restez en recul. Une décision de justice peut aussi être attendue.",
			  "Ne vous attendez pas à un grand changement dans votre vie. Vous allez récolter ce que vous méritez, rien de plus, rien de moins. Vous obtiendrez des autres ce que vous voulez bien leur donner, et n’en espérez pas plus, vous risqueriez d’être déçu. La vie ne vous offrira rien gratuitement, vous devrez aller chercher les choses et vous investir.",
			  "Il faut assumer votre passé. Vous ne reviendrez pas dessus, cessez de toujours ressasser des actions passées. Tournez-vous vers l’avenir, vous avez beaucoup plus à y gagner. Si vous avez un projet, sachez que pour le réussir vous devrez vous employer. Si vous le faites, vous réussirez. La Justice donne à chacun sa chance mais elle ne favorise personne.",
			  new File("files/img/cards/8-justice.jpg"));
	  Card hermite = new Card (9, "L'Hermite", 
			  "L’Hermite représente un homme d’un certain âge qui se tient appuyé sur une canne. Les trois rides sur son front forment une pyramide orientée vers le ciel, qui symbolisent la spiritualité de cet homme qui semble guidé par sa propre force intérieur.\r\n"
			  + "\r\n"
			  + "L’homme tient dans sa main droite une lampe qui permet d’éclairer son chemin et de présenter à son entourage la lumière qui émane de son environnement. Sa canne est de couleur chair, ce qui montre que le chemin menant au spiritualisme et à la recherche de soi-même est accessible au commun des mortel.\r\n"
			  + "\r\n"
			  + "L’homme semble animé par une quête profonde, ce qui donne à cette arcane une dimension occulte marquée.",
			  "Vous êtes un grand solitaire. Vous êtes mature et réfléchi, la sagesse vous habite. Vous aimez philosopher longuement que les détails de votre quotidien, faute de partager suffisamment vos sentiments avec des amis. Vous faites de votre solitude un atout, et avez développé depuis longtemps une personnalisé mystérieuse dont vous n’ignorez pas qu’elle génère une attirance du sexe opposé. Vous vous demandez cependant comment la gérer et convertir cela en relation.",
			  "Vous voilà complètement coupé du monde. La solitude vous mange chaque jour un peu plus. Vous vous refermez sur vous-même, vous avez beau faire des efforts, vous avez l’impression de reculer à chaque tentative d’avancée. Vous êtes perdu dans ce monde où tout tourne autour de vous, vous en devenez même égoïste et narcissique. Vous avez l’impression de ne pas compter pour les autres, alors vous leur rendez bien : ils ne comptent pas pour vous non plus. Et vous voilà dans le cercle vicieux de la timidité.",
			  "Vous devez faire un travail sur vous-même. L’Hermite aime s’écouter et réfléchir à ses problèmes au point de se persuader qu’ils sont insolvables. Il faut sortir de ce cycle et vous ouvrir au monde, il est bien plus beau que ce que vous imaginez. “L’enfer, c’est les autres” ne doit plus être votre adage. Méditez sur votre situation et allez de l’avant : rencontres, sorties, altruisme.",
			  "Concrétiser est pour vous un processus lent et complexe. Il n’est pas impossible, mais vous allez devoir vous employer. L’Hermite a tendance à ralentir les choses. Il vous faudra faire preuve de beaucoup de persévérance pour atteindre vos objectifs personnels et professionnels. Rien ne vous sera donné gratuitement, vous devrez vous battre, mais le résultat sera là pour récompenser vos efforts.",
			  "Sentimentalement, l’Hermite n’augure rien de bon. C’est la solitude qui est suggérée. Il peut s’agir d’une solitude au sens propre, ou d’une solitude au sein même d’un couple, lorsque l’on ne parvient pas à partager suffisamment de choses avec la personne aimée. Vous devez agir avec maturité et prendre des précautions sur le plan du travail. Ne prenez pas de décision hâtive que vous pourriez regretter.",
			  new File("files/img/cards/9-hermite.jpg"));
	  Card roue = new Card (10, "La Roue de Fortune",
			  "La Roue de Fortune présente roue en mouvement sur laquelle se tiennent 3 étranges créatures. Celle de gauche se dirige vers le sol, qui symbolise la matière. Celle de droite en revanche se dirige vers le ciel, qui symbolise le spiritualisme et l’esprit. Au centre de la roue, se dispose la troisième créature qui semble stable. Elle tient une épée et porte sur sa tête une couronne qui lui confère autorité et légitimité.\r\n"
			  + "\r\n"
			  + "La roue présente une manivelle que personne ne contrôle. Pourtant, elle semble tourner d’un mouvement perpétuel, qui indique l’alternance des choses et le changement.\r\n"
			  + "\r\n"
			  + "La Roue de Fortune souvent perçue comme la roue de vie et de mort symbolise le changement. Elle porte le numéro 10 et peut être interprétée comme la fin du premier cycle.",
			  "Vous êtes un bon vivant, capable de prendre le bon côté des choses et de ne pas voir le mauvais. Éternel optimiste, vous êtes un opportuniste, tant dans le monde professionnel que dans votre vie personnelle. Une occasion n’a pas besoin de se présenter à vous deux fois pour que vous la saisissiez : vous êtes à l'affût, et en recherche de bonnes affaires.",
			  "Attention à ne pas tomber dans un cercle vicieux dangereux. La surenchère est votre façon de fonctionner, mais il faudra parfois savoir vous calmer un peu si vous souhaitez préserver votre famille et vos amis. Vous risquez à tout moment une crise liée à votre façon de gérer les évènements parfois trop impulsive et peu réfléchie.",
			  "Vous avez toujours eu un côté chanceux. Il est fortement possible que des évènements se produisent pour vous sortir des situations compliquées auxquelles vous avez à faire face. Elles pourront changer votre vie plus ou moins en profondeur, il faudra donc ne pas hésiter à saisir ces occasions pour résoudre votre problématique.",
			  "Les évènements risquent de s’enchainer au mieux dans les prochaines semaines. Comme l’expression le dit, “la roue tourne”, et la Roue de Fortune montre clairement un renouveau rapide et positif dans votre vie. Professionnellement, une mutation peut être à envisager. Côté coeur, le bonheur pourrait revenir et une relation plaisante verra le jour.",
			  "La Roue est là pour vous montrer que vous êtes le seul maître de votre destin. C’est vous qui pouvez influer dessus, c’est à vous de choisir votre vie et de tracer votre route. Personne ne pourra s’y opposer. Allez au bout de vos envies et de vos rêves. A vous de faire tourner cette fameuse roue, à vous de la pousser aussi loin que possible.",
			  new File("files/img/cards/10-roue-fortune.jpg"));
	  Card force = new Card (11, "La Force",
			  "Cet arcane représente une femme, tenant entre ses mains un chien dont elle ouvre la gueule. Cette femme domine totalement ce chien, pourtant sans grand effort. On comprend alors que c’est de la force mentale et spirituelle dont on veut parler, et non pas de la force physique et brutale.\r\n"
			  + "\r\n"
			  + "Il s’agit du numéro 11 du tarot de Marseille. La femme est vêtue de deux couleurs dominantes : le rouge et le bleu. Le rouge est le symbole de la force et de la vitalité, et le bleu de l’intelligence et de l’esprit.\r\n"
			  + "\r\n"
			  + "On remarque que la femme est aussi vêtue d’un chapeau de grande taille, qui fait référence à la prédominance de l’esprit sur la matière.",
			  "Vous êtes dans une maitrise totale de vous-même. Le courage vous anime, vous aimez les défis, vous êtes un fonceur. Mais l’esprit suit, c’est ce qui fait votre plus grande force : vous n’agissez pas dans la précipitation, vous êtes réfléchi. Vous savez aller au bout de vous-même, vous faites preuve d’endurance dans les projets que vous menez.",
			  "Cependant, vous êtes quelqu’un de passionné à l’extrême. Vous avez tendance à aller trop loin lorsque vous vous investissez dans des choses. Vous êtes impatient et téméraire. Vous tombez facilement dans l’agressivité, vous vous emportez très vite. La force qui est en vous déborde et n’est pas maitrisée comme elle devrait l’être. Votre esprit est embrouillé par des sentiments impulsifs.",
			  "Vous devez travailler la maitrise de vous-même. Apprendre à mieux vous connaître, prendre du recul sur certaines choses. Lâchez prise ! Ouvrez-vous à des choses moins matérialistes. Apprenez la patience, développez votre volonté, et retrouvez un moral positif. Foncez, mais soyez prêt à être endurant. L’adage « tout vient à point à qui sait attendre » vous colle à la peau.",
			  "Vous avez projets en cours, vous irez probablement au bout. Vous avez la force pour gérer les difficultés qui vont se présenter à vous et pour les surmonter. Sachez rester endurant et courageux, vous allez en avoir grand besoin. Vos projets prennent du temps et il faut savoir faire preuve de patience pour atteindre les objectifs fixés.",
			  "Vous allez réussir les projets que vous menez actuellement. Vous saurez trouver la force mentale pour aller jusqu’au bout, vous devenez endurant, vous avez la sagesse et l’expérience pour enfin atteindre vos objectifs. Profitez-en, c’est une période faste pour vous, c’est le moment d’oser de nouvelles choses et de se fixer de nouveaux objectifs.",
			  new File("files/img/cards/11-force.jpg"));
	  Card pendu = new Card (12, "Le Pendu",
			  "Le pendu est une carte à l’envers. Le personnage est en effet suspendu par un pied à un arbre, la tête en bas. Il a les mains liées dans le dos. Ce pendu pourrait tout à fait être mort, et pourtant son visage est étonnamment serein et confiant. Il semble dans l’attente de quelque chose, il est figé dans une situation bien délicate.\r\n"
			  + "\r\n"
			  + "On sent ce personnage dans une impossibilité totale d’action ; il est déconnecté du réel, il n’a plus les pieds sur terre.",
			  "Vous vivez une période pleine d’attente et de passivité. Attention à ne pas vous oublier et à ne pas vous éloigner trop de l’action pour tomber dans l’inaction la plus totale. Il vous est difficile d’avoir une vision à moyen-terme, vous avez du mal à vous mettre des objectifs et la procrastination a tendance à vous mettre des bâtons dans les roues.",
			  "Cependant il est clair que vous subissez un très gros blocage dans votre vie. Il peut s’agir d’un blocage sentimental, d’une difficulté à aimer à nouveau une personne ou à être aimé. Vous êtes dans l’attente, vous êtes immobiles, vous êtes paralysé par un évènement ou une personne. Un obstacle vous paraît infranchissable et vous empêche d’avancer.",
			  "Vous devez ralentir, patienter, attendre. Des évènements se succèdent trop vite autour de vous, il est venu le temps de prendre du recul et de vous poser quelques instants. Ne soyez pas pressé d’aboutir à un résultat, restez en retrait, sachez vous effacer et analyser les situations avant d’agir à nouveau. Vous gagnerez en expérience et pourrez avoir une vision différente des évènements qui vous aidera à les surmonter.",
			  "La réponse est l’attente, le blocage. Vos projets n’aboutissent pas encore et pourraient prendre une tournure problématique. Vous devez attendre, laisser passer un peu de temps. Soyez plutôt dans l’inaction et dans la passivité afin d’éviter de faire de mauvais choix. Il vaut parfois mieux ne rien faire que de se précipiter et faire des erreurs : il est toujours difficile de revenir en arrière.",
			  "Le Pendu vous indique ici la nécessité d’attendre. Vous êtes dans une situation de blocage en termes de communication, de blocage dans vos projets, de blocage sentimental, ou de blocage dans le cadre de votre travail. Le Pendu vous demande de prendre sur vous et d’attendre. Essayez peut-être de lâcher un peu prise, tout en restant dans une situation d’attente.",
			  new File("files/img/cards/12-pendu.jpg"));
	  Card arcanne = new Card (13, "L'Arcane Sans Nom (La Mort)",
			  "Sur cette carte on peut voir un squelette courbé, qui tient dans sa main une faux. Symboles de la mort, ces deux éléments nous orientent sur la signification de la carte.\r\n"
			  + "\r\n"
			  + "Le squelette est penché vers l’avant et à ses pieds on remarque d’autres morceaux de squelettes (quelques mains, quelques têtes). L’ambiance de la carte est très négative.",
			  "Vous savez vous remettre en question et avez franchi une étape importante dans votre vie. C’est la fin de quelque chose, probablement la fin d’une période difficile qui s’achève enfin. Vous avez atteint un but, une limite, un objectif. Un projet arrive à son terme ou prend une autre dimension. Tournez la page, il est temps d’écrire la suivante.",
			  "Mais vous êtes dans la négation de la réalité. Vous refusez de voir que quelque chose a changé autour de vous. C’est la fin d’une situation, peut-être la fin d’une relation amoureuse ou d’une relation de travail. Il est difficile d’admettre certaines choses, surtout lorsqu’il s’agit de la fin d’une période qui fut heureuse.",
			  "Il vous faut envisager une rupture. Un de vos projets doit se terminer, trop d’énergie a été dépensée. Vous devez mettre un terme à une relation ou en revoir les conditions. Une transformation est nécessaire dans votre vie afin de retrouver une dynamique positive. Côté travail, il est possible qu’un changement soit opportun et qu’il serait bien accueilli par votre entourage.",
			  "Reconsidération totale de votre projet, de votre relation, de vos idées ou encore de votre façon de mener votre vie. C’est une annonce proche de vous : ce bouleversement dans votre vie devrait arriver rapidement. Il est nécessaire pour vous permettre de continuer à avancer. Une limite a été atteinte, il faut la surpasser.",
			  "C’est une nécessité pour vous de déclencher une rupture par rapport à votre vie actuelle. Il faut savoir mettre fin à certaines choses pour en découvrir de nouvelles. Vous risquez de traverser un bouleversement important mais vous trouverez les forces pour y faire face. Le changement doit avoir lieu maintenant, il ne faut pas en avoir peur.",
			  new File("files/img/cards/13-mort.jpg"));
	  Card temperance = new Card (14, "La Tempérance", 
			  "Il s’agit d’un ange, qui tient entre ses mains deux amphores. Ce personnage semble faire circuler un fluide de l’un à l’autre. Sa tête est penchée vers la droite et son regard est apaisant. Au dernier plan, on remarque un paysage simpliste mais joli et positif.\r\n"
			  + "\r\n"
			  + "Cet ange a deux ailes étendues derrière elle, qui lui donnent le pouvoir de voler. Elle bénéficie de cette force tout en faisant preuve d’une grande tranquillité sur terre.",
			  "Vous vous sentez bien dans votre peau, droit dans vos bottes. Vous êtes sociable et savez vous montrer pertinent et intéressant en société. Votre gentillesse vous offre les faveurs de vos amis et votre succès vous offre l’opportunité de vous faire valoir. Vous êtes une personnalité intéressante, vivante, heureuse.",
			  "Mais vous avez de gros soucis de communication. Les gens autour de vous ont du mal à vous comprendre et les messages que vous envoyez ne trouvent souvent pas de récepteur. Vous manquez de confiance en vous et de sérénité. Vous prenez le risque d’abandonner des projets qui vous tiennent pourtant à cœur.",
			  "Vous devez communiquer d’avantage avec vos proches et votre entourage. Vous devez tempérer votre caractère et rester calme lorsque des situations qui vous dépassent se présentent. Pensez aussi à modérer vos ardeurs professionnelles et amoureuses, vous gagnerez en crédibilité auprès de votre entourage et serez gagnant sur le long terme.",
			  "Concrétisation, renouveau et réussite. Vos projets vont aboutir dans la sérénité et le calme. Vous allez atteindre vos objectifs sans avoir à lutter ou à forcer votre chance. Vous êtes dans une bonne dynamique : profitez-en. Le succès vous attend tranquillement, laissez-vous porter jusqu’à lui. Vous pourrez alors planifier de nouveaux projets que vous mettrez en œuvre avec succès.",
			  "La Tempérance vous apportera le succès attendu. Cependant, il faudra rester humble et ne pas hésiter à faire quelques concessions. Vous pourrez ainsi atteindre une meilleure harmonie dans votre vie. Vous rencontrerez des difficultés que vous pourrez franchir avec patience et volupté. Dans votre vie amoureuse, vous allez vers une amélioration et vers l’aboutissement tranquille d’une relation.",
			  new File("files/img/cards/14-temperance.jpg"));
	  Card diable = new Card (15, "Le Diable", 
			  "Cette carte comporte trois personnages. L’un est sur un piédestal, et possède deux grandes ailes dans son dos. Il possède aussi deux cornes sur sa tête. Il tient dans sa main gauche une épée par la pointe. Son visage est surprenant et semble souriant : il tire la langue.\r\n"
			  + "\r\n"
			  + "Les deux personnages en contrebas sont enchainés à lui, et se font face l’un l’autre.",
			  "Vous êtes un créatif ! Vous aimez imaginer, créer, inventer. Vous êtes un malin, et vos amis le savent. Mais vous pouvez aussi vous montrer parfois calculateur et cela ne plaît pas à tout le monde. Vous fonctionnez à l’intuition et aimez faire les choses rapidement, avec les gens que vous aimez. Vous débordez d’énergie et d’envies, mais manquez parfois d’organisation.",
			  "Malheureusement vous faites face à de nombreuses difficultés. Vous êtes esclave de vous-même et il vous est difficile de vous en sortir. Vous avez pu vous empêtrer dans des situations complexes et malsaines : de sales histoires dans lesquelles vous vous êtes retrouvé sans trop comprendre pourquoi ni comment.",
			  "Vous allez bénéficier d’une vague positive qu’il faudra savoir gérer. C’est à prendre ou à laisser. Cette phase ne sera pas facile à gérer et vous demandera beaucoup d’énergie. Cependant si vous parvenez à maitriser ceci, votre vie avancera grandement et vous franchirez un véritable cap. Sachez prendre cet évènement comme une chance à saisir.",
			  "Le Diable vous procure une énergie qu’il sera difficile de contrôler. Vous risquez de perdre pied. Vos projets seront alors compliqués à concrétiser. Vos relations conflictuelles et tâchées par des incompréhensions. Vous aurez du mal à maîtriser les situations dans lesquelles vous allez être plongé quotidiennement.",
			  "Avec le Diable, vous risquez de vous retrouver dans une situation de trouble. Vous devez rester sur vos gardes et vous méfier de certains pièges dans lesquels vous pourriez tomber. Sur le plan professionnel, méfiez-vous de vos collègues qui pourraient vous faire un mauvais coup. Sur le plan amoureux, ne laissez pas dégénérer une situation déjà mal embarquée.",
			  new File("files/img/cards/15-diable.jpg"));
	  Card maison = new Card (16, "La Maison-Dieu",
			  "La maison-Dieu, également appelé La Tour, représente un édifice sur lequel s’abat la foudre. Deux personnages semblent s’échapper de l’édifice. La sérénité sur leur visage est signe que leur chute n’est pas dramatique. Ils semblent être en suspension dans l’air, sans se soucier de la tour qui s’effrondre.\r\n"
			  + "\r\n"
			  + "Au soleil, observe un champ de couleur jaune avec quelques touffes d’herbe verte qui suggère que la vie est présente autour de l’édifice et ce malgré l'effondrement de la tour.\r\n"
			  + "\r\n"
			  + "Ne vous méprenez pas, si la tour s’effondre, les couleurs et le tons adoptés sur la lame de la Maison-Dieu ont une connotation très positive qui suggère une crise salutaire.",
			  "Vous traversez une période difficile. Vous risquez fortement de vivre une désillusion. Méfiez-vous de votre entourage, particulièrement professionnel. Déstabilisé, quelque chose ne tourne pas rond dans votre vie et vous le ressentez. Vous manquez de discernement de ne sachez plus comment vous sortir de cette situation bien embarrassante.",
			  "Il y a là une sérieuse mise en garde sur un risque d’échec que vous courrez, et que vous n’auriez pas identifié. Il peut s’agir d’un échec professionnel ou d’un échec d’ordre personnel. Le fait de ne pas avoir vu venir ce risque va vous blesser énormément et vous refroidir. Il n’est pas certain que votre projet sera pour autant impossible à réaliser. Mais il y a ici un avertissement très clair.",
			  "Vous courrez un risque d’échec. Il faut reconsidérer votre projet, repartir à zéro sur des bases différentes. Vous vous êtes trop engagé trop rapidement dans quelque chose qui ne vous correspond probablement pas. Méfiez-vous donc, et pensez qu’il est toujours temps de revenir en arrière, cela vous évitera bien des soucis.",
			  "Vous vous acheminez petit à petit vers un échec assez cuisant. Il vous faut absolument reconsidérer l’ordre établi. Vous risquez une rupture, voir même un divorce. Votre vie sentimentale va devenir plus compliquée qu’elle ne l’est actuellement, et vous devrez changer quelque chose pour revenir à une situation plus stable et confortable.",
			  "Vous êtes dans un processus inévitable. Vous allez subir un échec, ou du moins une reconsidération ou un gros changement de cap. A vous de bien le gérer pour qu’il soit positif dans votre vie et ne vous apporte que du mieux. Il sera peut-être difficile de prendre la décision de ce changement, mais il s’avèrera salutaire pour l’avenir.",
			  new File("files/img/cards/16-maison-dieu.jpg"));
	  Card etoile = new Card (17, "L'étoile", 
			  "L’Etoile représente une femme dénudée qui verse le contenu de deux vases rouge dans un cours d’eau. Son visage exprime douceur et sérénité. Au dessus de sa tête, 6 étoiles jaune, rouge et bleu encadrent une étoile plus volumineuse et particulièrement lumineuse représentée à l’aide de deux couleurs fortes : le jaune et le rouge.\r\n"
			  + "\r\n"
			  + "Cette lame porte en elle une dimension cosmique et inspire la confiance. Les étoiles ont toujours servis de repères aux hommes et ont une dimension occulte. En tant que guide, l’Etoile doit être un moyen de trouver son chemin dans ce vaste univers dans lequel nous évoluons.",
			  "Vous êtes quelqu’un de sensible qui réussi dans la vie. Vous avez l’esprit d’entreprise et aimez aller de l’avant, vous connaissez en général le succès dans ce que vous faites, c’est ce qui fait votre force. Votre entourage vous juge comme quelqu’un d’agréable et de raffiné qui sait faire plaisir aux autres et qui sait trouver les bons mots en toutes situations.",
			  "Attention, vos projets sont irréalistes. Vous avez énormément d’ambition, d’envies, de rêves, mais il faut savoir se modérer. Vous ne pourrez pas tous les réaliser, et pourtant vous croyez pouvoir le faire. Vous êtes un doux rêveur, trop souvent dans votre bulle et vous ne voyez pas le monde tel qu’il est vraiment.",
			  "Les espoirs que vous avez ont de bonnes chances d’aboutir. Il vous faut pour cela faire appel à votre capacité créative, à votre émotivité, et votre sensibilité. Ne soyez pas trop inquiets, si vous parvenez à réunir tous vos talents et toutes vos capacités mentales et physiques, vous parviendrez à vos objectifs sans aucune difficulté.",
			  "Un dénouement heureux est en vue. Vous êtes dans un bon cycle et l’avenir est tout aussi positif. Vos projets, vos envies, vos rêves, devraient se réaliser. Votre côté artistique vous donne une force qui vous permettra d’aller de l’avant et d’aller jusqu’à la réalisation de vos projets. Sentimentalement vous irez là où vous avez envie d’aller, vous êtes porté par un amour sincère.",
			  "Ne vous faites pas de soucis, vous êtes dans une très bonne dynamique. Les situations vont vers le mieux et vous devriez atteindre une période heureuse. Votre forte sensibilité vous rend craintif mais vous donne aussi la force d’aller jusqu’au bout des choses. Vous en serez récompensé car le succès est au rendez-vous.",
			  new File("files/img/cards/17-etoile.jpg"));
	  Card lune = new Card (18, "La Lune", 
			  "La Lune représente un astre de couleur bleue qui surplombe le monde et impose sa lumière symbolisée par des rayons de couleurs rouge blanche et bleue. Des gouttes de couleurs rouges, jaunes et bleues semblent émaner de la terre et se diriger en direction de la lune. Elles donnent à cette lame une dimension occulte.\r\n"
			  + "\r\n"
			  + "De chiens apparaissent la tête dressée vers cet astre et semblent hurler. Cela donne un côté chaotique à la carte qui renvoie aux angoisses primitives des êtres vivants.\r\n"
			  + "\r\n"
			  + "En contrebas de la lame apparaît un crustacé qui ressemble à une écrevisse. Celui-ci semble plongé dans une eau profonde et tente de s’en sortir. Il fait référence à notre fort intérieur et évoque sur un plan symbolique le subconscient des êtres vivants.\r\n"
			  + "\r\n",
			  "Vous vous faites beaucoup de soucis ces derniers temps. Vous êtes empêtré dans une situation qui semble ne plus avancer. Vous êtes embourbé et en avez conscience, mais ne parvenez pas à vous sortir de cette fâcheuse situation. L’angoisse vous gagne, vous vous sentez impuissant face à des évènements qui vous dépassent.",
			  "Mais vous vous laissez envahir par vos angoisses et vos phobies. Elles prennent le dessus sur vous, parvenant même à effacer votre personnalité pour vous faire devenir une personne différente de celle que vous étiez. Vous avez conscience de vos dérives mais ne parvenez pas à régler le problème du fait de votre peur de tout et de vos terribles craintes.",
			  "La Lune vous suggère l’attente. Vous n’êtes pas en mesure d’agir pour gérer convenablement les évènements auxquels vous faites face, vous devez donc vous réfugier dans l’attente. Profitez-en pour vous recentrer sur vous-même, et tenter de chasser vos doutes et vos phobies. Vos projets professionnels comme personnels restent au point mort.",
			  "Les situations auxquelles vous faites face actuellement vous dépassent. Elles risquent de connaître une descente dans le mois qui vient. Les choses ne s’amélioreront pas, et risquent même de se détériorer. Vos projets resteront à l’état de projet. Ils ne sont pas prêts d’évoluer par manque d’investissement de votre côté. Vous êtes trop étrangers à ce qui vous entoure en ce moment.",
			  "La Lune vous amène une situation de doute et d’incertitude. Elle fait planer sur vous un voile sombre, qui n’augure rien de bon pour l’avenir. Les situations ne risquent pas de s’améliorer du jour au lendemain, et il faudra du temps pour revenir à une phase très positive. En amour, méfiez-vous des engagements trop rapides et des promesses.",
			  new File("files/img/cards/18-lune.jpg"));
	  Card soleil = new Card (19, "Le Soleil", 
			  "Le Soleil représente un astre lumineux incarnant le visage d’un être humain avec des yeux, un nez et une bouche. Ils rayonnent sur la terre et ses rayons semblent apporter de la lumière à cette lame à dominante jaune.\r\n"
			  + "\r\n"
			  + "A l’inverse de La Lune, les gouttes semblent se diriger du soleil vers la terre et symbolisent la fertilité et la chaleur. Le Soleil apporte à l’homme l’énergie et les richesses nécessaires à son épanouissement. Contrairement à La Lune qui renvoie à la figure maternelle, le Soleil renvoie à la masculinité, au visage du père.\r\n"
			  + "\r\n"
			  + "Plus bas, deux enfants se tiennent debout l’un en face de l’autre et semblent éblouis par le rayonnement du soleil. Ces derniers semblent heureux, protégés et évoquent l'insouciance et le bonheur.",
			  "Le Soleil vous apporte toute la chaleur nécessaire à la réussite de vos projets et de votre vie personnelle. Il est votre allié dans les tâches du quotidien. Il est votre protecteur, et vous permet de rester chaleureux, créatif. Vous êtes maître de votre vie et vous le savez, le soleil vous aide à dominer vos peurs et à avancer toujours plus.",
			  "Votre orgueil va vous perdre. Vous vivez dans une illusion, celle d’un contrôle total de votre vie par votre personne. Cela vous empêche de voir certaines choses que votre entourage remarque et qui risquent de vous nuire à moyen terme. Méfiez-vous de vous-même, apprenez à bien vous connaître et ne vous voilez pas la face sur vos capacités ou vos chances d’atteindre certains objectifs.",
			  "Le Soleil vous protège contre les soucis de la vie. Cependant il est aussi là pour vous montrer que vous devez aller de l’avant, et mobiliser toutes les forces qui sont en vous. Votre sensibilité, votre curiosité et votre courage devront être réunis pour avancer et résoudre vos soucis. Vous y parviendrez sans aucun doute, mais il faudra y mettre du votre.",
			  "Réussite sur tous les plans. Réussite professionnelle d’abord : une promotion peut arriver, ou un changement de poste avec un salaire plus intéressant. Réussite personnelle ensuite : tout va bien dans vos relations, et de nombreux éléments vous prouvent chaque jour que vous plaisez au sexe opposé et que vous êtes dans une très bonne dynamique sur ce plan.",
			  "Le Soleil est une jolie preuve de réussite. Cette carte en synthèse ne laisse pas le moindre doute : vous êtes en route vers le succès. Vos talents personnels, votre investissement, et la précieuse aide de votre entourage, vont vous permettre d’aller au bout de projets dans lesquels vous avez beaucoup mis d’espoirs, depuis de nombreux mois.",
			  new File("files/img/cards/19-soleil.jpg"));
	  Card jugement = new Card (20, "Le Jugement", 
			  "La lame décrit un angelot tenant une trompette sur laquelle est accrochée un drapeau. L’ange semble flotter dans les nuages bleus et regarder le monde des vivants. Depuis les nuages, émanent des rayons de couleurs jaunes et rouges qui indiquent le rayonnement du ciel sur la terre.\r\n"
			  + "\r\n"
			  + "Le Jugement présente 3 individus. Le personnage au centre se tient de dos tandis qu’une femme et un homme se tiennent à ses côtés et semblent prier.\r\n"
			  + "\r\n"
			  + "Le Jugement renvoie à l’idée de vie et de mort et fait référence à l'au-delà. Il apporte une note d’espérance dans la mesure où il rappelle à l’être humain la dualité qui existe entre le terrestre et le divin.",
			  "Vous êtes sans aucun doute parvenu à une phase de renouveau total dans votre vie. Tant sur le plan sentimental que sur le plan professionnel où l’on voit clairement des évolutions, vous avez su prendre votre vie en main et aller de l’avant. Vous avez changé votre prisme de réflexion et vous voyez maintenant le verre à moitié plein au lieu de voir le verre à moitié vide. Bravo, l’avenir vous est ouvert.",
			  "Vous êtes très influençable et cela va vous jouer des tours. Vous avez l’impression de maîtriser les choses, mais vous êtes guidés par des personnes qui jouent avec vous. Vous manquez de recule et vous persuadez de choses qui n’existent pas. Des évènements extérieurs risquent de venir perturber votre quotidien et vous aurez du mal à trouver des solutions.",
			  "Vous devez changer votre champ de vision. De nombreuses choses vous échappent dans votre vie et cela ne peut plus durer. Votre entourage s’en rend compte et vous envoie des messages plus ou moins clairs. A vous de vous relever en sortant du cadre et en réinventant certains aspects de votre personnalité. Vous devez aller de l’avant.",
			  "Vous allez évoluer très positivement ces prochains mois. Vous avez pris des décisions difficiles et vous voilà dans un nouveau cycle très positif. Votre entourage a remarqué ces changements et vous le fait savoir. Vous pouvez désormais vous lancer dans de nouveaux projets qui ont toutes les chances d’être couronnés de succès.",
			  "Le Jugement vous apporte des changements rapides dans votre vie. Ces changements seront bien accueillis et très positifs pour vous. Sur le plan professionnel, il peut s’agir d’une mutation inattendue, ou bien d’une offre d’emploi à laquelle vous ne vous attendiez pas. Sur le plan amoureux, vous ferez de nouvelles rencontres qui risquent de vous bouleverser.",
			  new File("files/img/cards/20-jugement.jpg"));
	  Card monde = new Card (21, "Le Monde", 
			  "Dernière arcane du cycle, Le Monde représente une femme dénudée qui se tient sur sa jambe droite. Elle semble en totale adéquation avec son environnement. Autour d’elle, est disposée une couronne de laurier de différentes couleurs, qui donne à cette femme une dimension universelle. La femme tient dans ses mains les outils qui se présentaient devant le Bateleur (I) au début du cycle et semble maîtriser parfaitement les différents éléments qui composent cette arcane.\r\n"
			  + "\r\n"
			  + "Au quatre coins de la carte, on observe un ange, une vache, un aigle, et un lion qui sont les symboles des 4 évangélistes Saint Mathieu, Saint Luc, Saint Jean et de Saint Marc. Il place le divin autour de cette femme qui observe le lien qui existe entre l’univers et le sacré.\r\n"
			  + "\r\n"
			  + "Le personnage est arrivé au bout de son cycle et semble avoir acquis les connaissances nécessaires à la compréhension de son environnement et à sa place dans le monde.",
			  "Les planètes sont avec vous ! Vous êtes chanceux, vous avez le destin entre vos mains. Vous avez les capacités pour réussir dans ce que vous voulez, c’est une chance unique. Le Monde vous appartient, à vous d’en profiter et d’en tirer les bénéfices les plus forts. Vos projets seront couronnés de succès et votre entourage plein de reconnaissance envers vos qualités.",
			  "Un très gros obstacle va vous barrer la route. Le projet que vous menez actuellement risque même d’être interrompu. Cet obstacle sera inattendu et de forte taille, il ne dépendra pas de vous mais viendra de l’extérieur. Le Monde va vous jouer un triste tour, et vous devrez redoubler d’efforts si vous souhaitez mener à bien vos projets.",
			  "Vos chances de réussite sont plus fortes que jamais. A vous d’utiliser au mieux les ressources dont vous disposez pour les convertir. Professionnellement vous allez remporter de gros contrats et créer des jalousies autour de vous. Côté coeur vous êtes envahi par une lumière enchantée qui vous couvre de bonheur et restera longtemps avec vous.",
			  "Vous allez atteindre la gloire et la reconnaissance de tous vos pairs. C’est une obtention de diplôme, la réussite d’une formation. C’est aussi un client satisfait par votre travail, un patron qui vous félicite, des collègues qui vous savent indispensable. Votre coeur est rempli de joie et vous générez autour de vous des sourires et de la chaleur.",
			  "Vous atteignez l’état de grâce. Votre succès est total. Le Monde vous a offert un formidable cadeau, et vous allez maintenant pouvoir en profiter. Votre entourage est fier de vous. Côté coeur, la vie à deux va pouvoir reprendre tranquillement, comme lors des plus belles périodes. La Terre continue à tourner, et vous aussi : vous rayonnez de bonheur dans une sphère de succès et de réussite.",
			  new File("files/img/cards/21-monde.jpg"));
	  
	  cards.add(mat);cards.add(bateleur);cards.add(papesse);cards.add(imperatrice);cards.add(empereur);cards.add(pape);cards.add(amoureux);cards.add(chariot);cards.add(justice);cards.add(hermite);cards.add(roue);cards.add(force);cards.add(pendu);cards.add(arcanne);cards.add(temperance);cards.add(diable);cards.add(maison);cards.add(etoile);cards.add(lune);cards.add(soleil);cards.add(jugement);cards.add(monde);
	  
	  return cards;
  }
  
}