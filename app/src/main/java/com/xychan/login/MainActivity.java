package com.xychan.login;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Base64;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.UUID;

public class MainActivity extends Activity {

    ///coisas
    private String TeamName = "<font face='monospace'><font color='black'><b>GODS</b>TEAM</font></font>";
	public String sGameActivity = "namepacknameapp";
	public native String Dialog();
	public native String Image();

    public final void CriarBackgrounds() {
        this.BackgroundTabela = new GradientDrawable();
        this.BackgroundTabela.setShape(0);
        this.BackgroundTabela.setColor(-1);
        this.BackgroundTabela.setStroke(ConverterDP(1), -7829368);
        setCornerRadius(this.BackgroundTabela, (float) ConverterDP(0), (float) ConverterDP(0), (float) ConverterDP(5), (float) ConverterDP(5));
        this.BackgroundLine = new GradientDrawable();
        this.BackgroundLine.setShape(0);
        String str = "#007bff";
        this.BackgroundLine.setColor(Color.parseColor(str));
        setCornerRadius(this.BackgroundLine, (float) ConverterDP(10), (float) ConverterDP(10), (float) ConverterDP(0), (float) ConverterDP(0));
        this.BackgroundUsuarioEdit = new GradientDrawable();
        this.BackgroundUsuarioEdit.setShape(0);
        String str2 = "#80717171";
        this.BackgroundUsuarioEdit.setStroke(ConverterDP(1), Color.parseColor(str2));
        setCornerRadius(this.BackgroundUsuarioEdit, (float) ConverterDP(4), (float) ConverterDP(0), (float) ConverterDP(0), (float) ConverterDP(4));
        this.BackgroundUsuario = new GradientDrawable();
        this.BackgroundUsuario.setShape(0);
        this.BackgroundUsuario.setColor(Color.parseColor(str2));
        this.BackgroundUsuario.setStroke(ConverterDP(1), Color.parseColor(str2));
        setCornerRadius(this.BackgroundUsuario, (float) ConverterDP(0), (float) ConverterDP(4), (float) ConverterDP(4), (float) ConverterDP(0));
        this.BackgroundCheck = new GradientDrawable();
        this.BackgroundCheck.setShape(0);
        this.BackgroundCheck.setStroke(ConverterDP(1), -7829368);
        this.BackgroundEntrar = new GradientDrawable();
        this.BackgroundEntrar.setShape(0);
        this.BackgroundEntrar.setColor(Color.parseColor(str));
        this.BackgroundEntrar.setCornerRadius((float) ConverterDP(5));
        this.BackgroundInfo = new GradientDrawable();
        this.BackgroundInfo.setShape(0);
        this.BackgroundInfo.setColor(Color.parseColor("#ffa500"));
        this.BackgroundInfo.setCornerRadius((float) ConverterDP(4));
        this.BackgroundLogo = new GradientDrawable();
        this.BackgroundLogo.setShape(1);
        this.BackgroundLogo.setColor(Color.parseColor(str));
    }

    public final void CriandoImagems() {
        byte[] imageBytesUser = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAABTUlEQVRIS73UISxFcRTH8Y8oSUZgYyNJxmY2KhNEGpEmkT2ZpBFpRMGobGZjksTGRmCSJLK/vWvP8+7//nE58e6c8/2f3/md2yQt5jCC0Wr6EY6xWVTeVJSAMwzk5J1jMNajCLCDqYJH7GI6LycGmMFWwoQhZRbbjXJjgJTXZz1zp4gB7tCROME9Or87wQ26EgG36P4uIOgf9pASQf+why8Rkyh4fyOlO+bzbqLIprEbyNjRWygChCYxN0VvIBSnAEJe2MUkhqvPPsFenvdrZU0FJK4ifcmt6EM/WrCP07ryIUzgGRe4xFM9otEEwTnBQfXxgqvqx140N8gJf9fgqI+oB7z+WIvPhR99awGLWC0JsIS1Whe14aGk5lmbdjxmE4zhoGTAOA4zQJnyZO98lykDVLBc8gQrqPwb4M+XHNQJV7mOnl9KdY2F6vV7A9ESNhl4JmGYAAAAAElFTkSuQmCC", 0);
        this.UsuarioLogo = BitmapFactory.decodeByteArray(imageBytesUser, 0, imageBytesUser.length);
        byte[] imageBytesSenha = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAABPElEQVRIS+3UvytFcRjH8dedbSIyKUoyshIj/wKDSSkpg9m9q0lSymTgT5DRr5VRUsIkSjYzfW/n1Llfvvc4w110n+V0nu/n+3x63s9zTk15DGMV45jM5De4wz6e25WoldRfxh56ErpPrOEwVaedwTQuyxtsKmZw9Zs2ZdCHe/RGl26z94ko/4ExvMcmKYNtbBbE52ggPEPMYit75rIdbPzV4AQLBfEUwmCLEQZ+XUiE86BriVQHTwjbE+IRI4lZnEVd9MeYUgZfEZ65hEE9Q5UfB12OsZn7fwYrGIraDi1fRIhyhIFA2KY8wqa94CBPFBEVuSeQV0o3a+cGiziqdL1cvITj3CDehvLr5YqAq941aAeq44jCXBudnEHXoPRDaEE0gNfSK9UEg3gr/ovmsYvRanV+qB+wjtNw8g374UYZWHY1jwAAAABJRU5ErkJggg==", 0);
        this.SenhaLogo = BitmapFactory.decodeByteArray(imageBytesSenha, 0, imageBytesSenha.length);
        byte[] imageBytesCheck = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAABWUlEQVRIS9WTzytFQRTHPycbGxsbNjY2FjZSFrKxkoWNhR97C/lXlL/h7RCllFJKKaUUpVi9KKWUUkoppRzN7Vw99945977evQuznDnz+czMma/Q8JCG+fw/garu2atsishVrTcw+JIJXoC12gQZeNra+1oEEXiQXPcscOC3wEpPAgd+k8BF2olAVSeBLaAtIutVsuE9i8EfAkdUdR5oAcMG3heRZU/iwC+BVRF5TPcHwR0wngFGJQ78wuBPnawgCAvTBSfOSRz4ucGfs5wgGAN2gQlP4sDPDB6ClRtpk0dNMlUksbk0oZ0lpwZ/jfXs95uq6giwA8xU+UXAicHfvPo/OVDVIbvJbInk2ODvZYfJBU1VB+0mc5HNRwb/KIMnOSgqUtUBYBtYyKwfGvyzCjwqsHT3m2TRYAcG/6oKdwUm6bPnCo3cEJHvbuClgm5h0RzUASrNQVOSH82kgSiGw1wJAAAAAElFTkSuQmCC", 0);
        BitmapFactory.decodeByteArray(imageBytesCheck, 0, imageBytesCheck.length);
        byte[] imageBytesGods = Base64.decode(Image(), 0);
        this.LogoGods = BitmapFactory.decodeByteArray(imageBytesGods, 0, imageBytesGods.length);
    }

    public TextView AvisoText;
    public GradientDrawable BackgroundCheck;
    public GradientDrawable BackgroundEntrar;
    public GradientDrawable BackgroundInfo;
    public GradientDrawable BackgroundLine;
    public GradientDrawable BackgroundLogo;
    public GradientDrawable BackgroundTabela;
    public GradientDrawable BackgroundUsuario;
    public GradientDrawable BackgroundUsuarioEdit;
    public RelativeLayout ButtonRelative;
    public TextView CreditosText;
    public Button EntrarButton;
    public LinearLayout EntrarLayout;
    public ImageView GodsImagem;
    public TextView InfoText;
    public LinearLayout LayoutInfo;
    public View Line1;
    public LinearLayout LineLayout;
    public Bitmap LogoGods;
    public LinearLayout PrincipalLayout;
    public EditText SenhaEdit;
    public ImageView SenhaImagem;
    public LinearLayout SenhaLayout;
    public Bitmap SenhaLogo;
    public LinearLayout TabelaLayout;
    public TextView TituloText;
    public EditText UsuarioEdit;
    public ImageView UsuarioImage;
    public LinearLayout UsuarioLayout;
    public Bitmap UsuarioLogo;
    public boolean isVisible = true;
    public Prefs prefs;


    @TargetApi(21)

    public void onCreate(Bundle savedInstanceState) {
        Context context = this;
        super.onCreate(savedInstanceState);
		System.loadLibrary("Security-XyChan");
        try {
            CriarBackgrounds();
            CriandoImagems();
			prefs = Prefs.with(this);
            PrincipalLayout = new LinearLayout(context);
            LayoutParams principalParams = new LayoutParams(-1, -1);
            PrincipalLayout.setLayoutParams(principalParams);
            PrincipalLayout.setOrientation(1);
            PrincipalLayout.setGravity(17);
            PrincipalLayout.setBackgroundColor(Color.parseColor("#e9ecef"));
            TabelaLayout = new LinearLayout(context);
            TabelaLayout.setLayoutParams(new LayoutParams(ConverterDP(300), -2));
            TabelaLayout.setOrientation(1);
            TabelaLayout.setElevation((float) ConverterDP(13));
            TabelaLayout.setBackground(BackgroundTabela);
            LineLayout = new LinearLayout(context);
            LineLayout.setLayoutParams(new LayoutParams(ConverterDP(300), ConverterDP(3)));
            LineLayout.setOrientation(0);
            LineLayout.setBackground(BackgroundLine);
            LineLayout.setElevation((float) ConverterDP(10));
            TituloText = new TextView(context);
            TituloText.setLayoutParams(new LayoutParams(-1, ConverterDP(45)));
            TituloText.setText(Html.fromHtml(TeamName));
            TituloText.setTextSize(2, 24.0f);
            TituloText.setGravity(17);
            Line1 = new View(context);
            Line1.setLayoutParams(new LayoutParams(-1, ConverterDP(1)));
            Line1.setBackgroundColor(-7829368);
            AvisoText = new TextView(context);
            AvisoText.setLayoutParams(new LayoutParams(-1, ConverterDP(45)));
            AvisoText.setText("Faça login para iniciar sua sessão");
            AvisoText.setTextColor(-16777216);
            AvisoText.setTextSize(2, 13.0f);
            AvisoText.setGravity(17);
            UsuarioLayout = new LinearLayout(context);
            LayoutParams usuarioLayoutParams = new LayoutParams(-1, -2);
            usuarioLayoutParams.leftMargin = ConverterDP(10);
            usuarioLayoutParams.rightMargin = ConverterDP(10);
            UsuarioLayout.setLayoutParams(usuarioLayoutParams);
            UsuarioLayout.setOrientation(0);
            UsuarioLayout.setGravity(17);
            UsuarioImage = new ImageView(context);
            UsuarioImage.setLayoutParams(new LayoutParams(ConverterDP(35), ConverterDP(35)));
            UsuarioImage.setPadding(ConverterDP(10), ConverterDP(10), ConverterDP(10), ConverterDP(10));
            UsuarioImage.setBackground(BackgroundUsuario);
            UsuarioImage.setImageBitmap(UsuarioLogo);
            UsuarioEdit = new EditText(context);
            LayoutParams editusuarioParams = new LayoutParams(ConverterDP(230), ConverterDP(35));
            UsuarioEdit.setLayoutParams(editusuarioParams);
            UsuarioEdit.setPadding(ConverterDP(8), ConverterDP(2), ConverterDP(2), ConverterDP(2));
            UsuarioEdit.setHint("Insira seu nome de usuário");
            UsuarioEdit.setTextSize(2, 15.0f);
            UsuarioEdit.setBackground(BackgroundUsuarioEdit);
            UsuarioEdit.setMaxLines(1);
            UsuarioEdit.setSingleLine(true);
            UsuarioEdit.setText(prefs.read("USER", ""));
            SenhaLayout = new LinearLayout(context);
            LayoutParams senhaLayoutParams = new LayoutParams(-1, -2);
            senhaLayoutParams.topMargin = ConverterDP(10);
            usuarioLayoutParams.leftMargin = ConverterDP(10);
            usuarioLayoutParams.rightMargin = ConverterDP(10);
            SenhaLayout.setLayoutParams(senhaLayoutParams);
            SenhaLayout.setOrientation(0);
            SenhaLayout.setGravity(17);
            SenhaImagem = new ImageView(context);
            SenhaImagem.setLayoutParams(new LayoutParams(ConverterDP(35), ConverterDP(35)));
            SenhaImagem.setPadding(ConverterDP(10), ConverterDP(10), ConverterDP(10), ConverterDP(10));
            SenhaImagem.setBackground(BackgroundUsuario);
            SenhaImagem.setImageBitmap(SenhaLogo);
            SenhaEdit = new EditText(context);
            SenhaEdit.setLayoutParams(new LayoutParams(ConverterDP(230), ConverterDP(35)));
            SenhaEdit.setMaxLines(1);
            SenhaEdit.setSingleLine(true);
            SenhaEdit.setPadding(ConverterDP(8), ConverterDP(2), ConverterDP(2), ConverterDP(2));
            SenhaEdit.setHint("Insira sua senha");
            SenhaEdit.setTextSize(2, 13.0f);
            SenhaEdit.setBackground(BackgroundUsuarioEdit);
            SenhaEdit.setInputType(129);
            SenhaEdit.setText(prefs.read("PASS", ""));
            ButtonRelative = new RelativeLayout(context);
            LayoutParams buttonRelativeParams = new LayoutParams(-1, ConverterDP(35));
            buttonRelativeParams.topMargin = ConverterDP(15);
            buttonRelativeParams.bottomMargin = ConverterDP(15);
            buttonRelativeParams.leftMargin = ConverterDP(10);
            buttonRelativeParams.rightMargin = ConverterDP(10);
            ButtonRelative.setLayoutParams(buttonRelativeParams);
            ButtonRelative.setGravity(19);
            EntrarLayout = new LinearLayout(context);
            EntrarLayout.setLayoutParams(new LayoutParams(-1, ConverterDP(35)));
            EntrarLayout.setOrientation(0);
            EntrarLayout.setGravity(21);
            EntrarButton = new Button(context);
            LayoutParams entrarParams = new LayoutParams(ConverterDP(80), ConverterDP(35));
            entrarParams.rightMargin = ConverterDP(10);
            EntrarButton.setLayoutParams(entrarParams);
            EntrarButton.setText("Entrar");
            EntrarButton.setTextColor(-1);
            EntrarButton.setGravity(17);
            EntrarButton.setPadding(0, 0, 0, ConverterDP(2));
            EntrarButton.setTextSize(2, 14.0f);
            EntrarButton.setBackground(BackgroundEntrar);
            EntrarButton.setAllCaps(false);
            EntrarButton.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						String Usuario = MainActivity.this.UsuarioEdit.getText().toString();
						String Senha = MainActivity.this.SenhaEdit.getText().toString();
						if (!Usuario.isEmpty()) {
							if (!Senha.isEmpty()) {
								String str = "PASS";
								String str2 = "USER";
								if (MainActivity.this.isVisible) {
									MainActivity.this.prefs.write(str2, Usuario);
									MainActivity.this.prefs.write(str, Senha);
								} else {
									MainActivity.this.prefs.write(str2, Usuario);
									MainActivity.this.prefs.write(str, Senha);
								}
								new Auth(MainActivity.this).execute(new String[]{Usuario, Senha});
								return;
							}
						}
						CharSequence charSequence = "Preencha este campo";
						if (MainActivity.this.UsuarioEdit.getText().length() == 0) {
							MainActivity.this.UsuarioEdit.setError(charSequence);
						}
						if (MainActivity.this.SenhaEdit.getText().length() == 0) {
							MainActivity.this.SenhaEdit.setError(charSequence);
						}
					}
				});
            LayoutInfo = new LinearLayout(context);
            LayoutInfo.setLayoutParams(new LayoutParams(ConverterDP(300), ConverterDP(35)));
            LayoutInfo.setBackground(BackgroundInfo);
            LayoutInfo.setVisibility(8);
            LayoutInfo.setGravity(17);
            LayoutInfo.setElevation((float) ConverterDP(13));
            InfoText = new TextView(context);
            InfoText.setLayoutParams(new LayoutParams(-1, ConverterDP(300)));
            InfoText.setTextSize(2, 12.0f);
            InfoText.setGravity(17);
            InfoText.setTextColor(-1);
            CreditosText = new TextView(context);
            principalParams = new LayoutParams(ConverterDP(300), -2);
            principalParams.topMargin = ConverterDP(10);
            CreditosText.setLayoutParams(principalParams);
            CreditosText.setText("Copyright \u00a9 GODs TEAM");
            CreditosText.setTextColor(-16777216);
            CreditosText.setTextSize(2, 13.0f);
            CreditosText.setGravity(17);
            setContentView(PrincipalLayout);
            GodsImagem = new ImageView(context);
            principalParams = new LayoutParams(ConverterDP(280), ConverterDP(90));
            GodsImagem.setLayoutParams(principalParams);
            GodsImagem.setScaleType(ScaleType.FIT_XY);
            GodsImagem.setImageBitmap(LogoGods);
            GodsImagem.setPadding(ConverterDP(3), ConverterDP(3), ConverterDP(3), ConverterDP(3));
            PrincipalLayout.addView(GodsImagem);
            if (VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("package:");
                stringBuilder.append(getPackageName());
                startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(stringBuilder.toString())), 2002);
            }
            new Handler().postDelayed(new Runnable() {
					public void run() {
						MainActivity.this.GodsImagem.setVisibility(8);
						MainActivity.this.AddViews();
						MainActivity.this.Alerta();
					}
				}, 1500);
            CarregarPerms();
        } catch (Exception e) {
            Toast.makeText(context, "Ocorreu um erro desconhecido Code: 101 - GodsTeam", 0).show();
        }
    }


    public void addInfoAuth(String resposta, String color) {
        this.LayoutInfo.setVisibility(0);
        this.InfoText.setText(resposta);
        this.BackgroundInfo.setColor(Color.parseColor(color));
        new Handler().postDelayed(new Runnable() {
				public void run() {
					MainActivity.this.LayoutInfo.setVisibility(8);
				}
			}, 4000);
    }

    public final void AddViews() {
        this.PrincipalLayout.addView(this.LineLayout);
        this.PrincipalLayout.addView(this.TabelaLayout);
        this.TabelaLayout.addView(this.TituloText);
        this.TabelaLayout.addView(this.Line1);
        this.TabelaLayout.addView(this.AvisoText);
        this.TabelaLayout.addView(this.UsuarioLayout);
        this.UsuarioLayout.addView(this.UsuarioEdit);
        this.UsuarioLayout.addView(this.UsuarioImage);
        this.TabelaLayout.addView(this.SenhaLayout);
        this.SenhaLayout.addView(this.SenhaEdit);
        this.SenhaLayout.addView(this.SenhaImagem);
        this.TabelaLayout.addView(this.ButtonRelative);
        this.ButtonRelative.addView(this.EntrarLayout);
        this.EntrarLayout.addView(this.EntrarButton);
        this.PrincipalLayout.addView(this.LayoutInfo);
        this.LayoutInfo.addView(this.InfoText);
        this.PrincipalLayout.addView(this.CreditosText);
    }


    public final void CarregarPerms() {
        getWindow().setFlags(1024, 1024);
        setRequestedOrientation(0);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public static void setCornerRadius(GradientDrawable gradientDrawable, float f1, float f2, float f3, float f4) {
        gradientDrawable.setCornerRadii(new float[]{f1, f1, f2, f2, f3, f3, f4, f4});
    }

    public final int ConverterDP(int value) {
        return (int) TypedValue.applyDimension(1, (float) value, getResources().getDisplayMetrics());
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 123 && VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Por favor, permita esta permiss\u00e3o, ent\u00e3o");
            stringBuilder.append(getString(2131427367));
            stringBuilder.append(" could be drawn.");
            Toast.makeText(this, stringBuilder.toString(), 1).show();
        }
    }

    public void Alerta() {
        byte[] arrayOfByte = Base64.decode("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", 0);
        CharSequence charSequence = "Discord";
        ((TextView) new Builder(this).setIcon(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length))).setTitle("    GODsTEAM").setCancelable(false)
		.setMessage(Html.fromHtml(Dialog())).setPositiveButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialogInterface, int i) {
					dialogInterface.cancel();
				}
			}).setNegativeButton(charSequence, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialogInterface, int i) {
					Intent intent = new Intent("android.intent.action.VIEW");
					intent.addFlags(268435456);
					intent.setData(Uri.parse("https://discord.gg/q4RCzZPcqt"));
					intent = Intent.createChooser(intent, "Abrir");
					intent.addFlags(268435456);
					MainActivity.this.startActivity(intent);
					dialogInterface.cancel();
				}
			}).show().findViewById(16908299)).setMovementMethod(LinkMovementMethod.getInstance());
    }
}

