<?php
error_reporting(E_ALL);
ini_set("display_errors", 1);

require_once('/home/site/wwwroot/simplesamlphp/src/_autoload.php');

$as = new \SimpleSAML\Auth\Simple('legrand-sp');
$session = \SimpleSAML\Session::getSessionFromRequest();
$session->cleanup();
?>

<script src="https://cdn.jsdelivr.net/npm/party-js@latest/bundle/party.min.js"></script>
<script>function showConfetti() {
  party.confetti(document.querySelector('.container'));
}</script>

<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="style.css">
    <link rel="icon" href="https://pbs.twimg.com/profile_images/1352260220056170497/_LWTp1G__400x400.jpg">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
    <title>SSO ADFS Legrand - Accueil</title>
</head>

<body>
    <div class="header">
        <a href="#" class="logo"><img style="width: 200px;"
                src="https://i.ibb.co/2y7VHbX/LR-PA-BIG-D-d49c52ab.png"></a>  
                <div class="header-right">
                <?php
                if(!$as->isAuthenticated()) {
                echo '<form><button type="submit" name="login">Connexion</button></form>';
            } else {
                echo '<form><button type="submit" name="logout">Déconnexion</button></form>'; 
            }
                ?> 
    </div>   
    </div>
    <?php
    if (!$as->isAuthenticated()) {
        echo '
    <h3>Bienvenue sur l\'application de test SSO !</h3>
    <br>
    <h4><U>Préambule :</U></h4>
    <br>
    <p>
    Bienvenue sur notre application interne, qui vous permet de vous connecter de manière simple et sécurisée à l\'ADFS Legrand grâce à SimpleSamlPhp et au protocole SAML. 
    Hébergée sur Azure et développée en PHP, notre application permet avant de s\'assurer que la communication d\'une application tierce à l\'ADFS fonctionne correctement.<br>
    </p>
    <br>
    <h4><U>Les possibilités de connexion :</U></h4>
    <br>
        <p class="nb">
        Deux cas de figure peuvent se présenter : 
        <ul>
            <li>
                <U>Si vous utilisez un périphérique autorisé et reconnu par Legrand</U> : veuillez rentrer votre nom et la première lettre de votre prénom. Exemple : Dupont Louis -> dupontl, avec votre mot
                de passe habituel AD. 
            </li>
            <li>
                <U>Si vous utilisez un périphérique extérieur</U> : veuillez rentrer votre adresse mail Legrand et votre mot de passe habituel AD. Vous serez normalement amené à valider votre connexion avec le système Authenticator. 
            </li>
        </ul>
    </p>
        ';}
        ?>
    <div class="container"> 
        <?php
    if (isset($_GET['login'])) {
        $as->login([
            'ReturnTo' => 'https://test-sso-legrand.azurewebsites.net/',
            'KeepPost' => false,
        ]);
    } elseif (isset($_GET['logout'])) {
        $as->logout([
            'ReturnTo' => 'https://test-sso-legrand.azurewebsites.net/',
        ]);
    }

    if ($as->isAuthenticated()) {
        $attributes = $as->getAttributes();
        $email = $attributes['email'][0];
        echo "<h3 id='feliz'>Félicitations !</h3>
        <br>
        Vous êtes bien connecté à l'ADFS Legrand. La connexion SAML s'est déroulée correctement.
        <br> <br>
        <p>Vous êtes connecté avec l'adresse : <b> $email</b></p><br>";
        ;
        echo "<script>showConfetti();</script>";
    } else {
        echo '';
    }
    ?>
    </div>

    <div style="padding-left:20px">

    </div>
    <?php echo ("<footer><p id='footer-centre'> " . date("Y") . " - Page de test SSO AAD Legrand - Nicolas DISSAUX - <a class='mail' 
                href='mailto:nicolas.dissaux@legrand.com'>nicolas.dissaux@legrand.com</a></p></footer>");
    ?>
    
</body>



</html>
