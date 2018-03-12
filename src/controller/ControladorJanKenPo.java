package controller;

public class ControladorJanKenPo {

	private view.PanelJanKenPo ventanaJanKenPo;

	public ControladorJanKenPo() {
		this.ventanaJanKenPo = new view.PanelJanKenPo();
		this.ventanaJanKenPo.getPiedra().addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				clickPiedra();
			}
		});
		this.ventanaJanKenPo.getPapel().addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				clickPapel();
			}
		});
		this.ventanaJanKenPo.getTijera().addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				clickTijera();
			}
		});
	}

	private void clickPiedra() {
		
	}

	private void clickPapel() {

	}

	private void clickTijera() {

	}

	public view.PanelJanKenPo getVentanaJanKenPo() {
		return ventanaJanKenPo;
	}
}
